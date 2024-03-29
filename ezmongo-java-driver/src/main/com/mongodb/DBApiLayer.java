/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;

/**
 * Concrete extension of abstract {@code DB} class.
 *
 * @deprecated This class is NOT part of the public API. It will be dropped in 3.x releases.
 */
@Deprecated
@SuppressWarnings("deprecation")
public class DBApiLayer extends DB implements Serializable {

    /** The maximum number of cursors allowed */
    static final int NUM_CURSORS_BEFORE_KILL = 100;
    static final int NUM_CURSORS_PER_BATCH = 20000;

    DBTCPConnector getConnector() {
        return _connector;
    }

    /**
     * @param mongo the Mongo instance
     * @param name the database name
     * @param connector the connector.  This must be an instance of DBTCPConnector.
     */
    protected DBApiLayer( Mongo mongo, String name , DBConnector connector ){
        super( mongo, name );

        if ( connector == null )
            throw new IllegalArgumentException( "need a connector: " + name );

        _root = name;
        _rootPlusDot = _root + ".";

        _connector = (DBTCPConnector) connector;
    }

    public void requestStart(){
        _connector.requestStart();
    }

    public void requestDone(){
        _connector.requestDone();
    }

    public void requestEnsureConnection(){
        _connector.requestEnsureConnection();
    }

    public WriteResult addUser( String username , char[] passwd, boolean readOnly ){
        requestStart();
        try {
            if (useUserCommands(_connector.getPrimaryPort())) {
                CommandResult userInfoResult = command(new BasicDBObject("usersInfo", username));
                userInfoResult.throwOnError();
                DBObject userCommandDocument = getUserCommandDocument(username, passwd, readOnly,
                                                                      ((List) userInfoResult.get("users")).isEmpty()
                                                                      ? "createUser" : "updateUser");
                CommandResult commandResult = command(userCommandDocument);
                commandResult.throwOnError();
                return new WriteResult(commandResult, getWriteConcern());
            } else {
                return super.addUser(username, passwd, readOnly);
            }
        } finally {
            requestDone();
        }
    }

    public WriteResult removeUser( String username ){
        requestStart();
        try {
            if (useUserCommands(_connector.getPrimaryPort())) {
                CommandResult res = command(new BasicDBObject("dropUser", username));
                res.throwOnError();
                return new WriteResult(res, getWriteConcern());
            }
            else {
                return super.removeUser(username);
            }
        } finally {
            requestDone();
        }
    }

    private DBObject getUserCommandDocument(String username, char[] passwd, boolean readOnly, final String commandName) {
        return new BasicDBObject(commandName, username)
               .append("pwd", _hash(username, passwd))
               .append("digestPassword", false)
               .append("roles", Arrays.asList(getUserRoleName(readOnly)));
    }


    private String getUserRoleName(boolean readOnly) {
        return getName().equals("admin") ? (readOnly ? "readAnyDatabase" : "root") : (readOnly ? "read" : "dbOwner");
    }

    protected DBCollectionImpl doGetCollection( String name ){
        DBCollectionImpl c = _collections.get(name);
        if (c != null)
            return c;

        if (Mongo.isClientModeEnabled()){
            c = new EzDBCollectionImpl(this, name);
        } else {
            c = new DBCollectionImpl(this, name);
        }
        DBCollectionImpl old = _collections.putIfAbsent(name, c);
        return old != null ? old : c;
    }


    /**
     * @param force true if should clean regardless of number of dead cursors
     * @throws MongoException
     */
    public void cleanCursors( boolean force ){

        int sz = _deadCursorIds.size();

        if ( sz == 0 || ( ! force && sz < NUM_CURSORS_BEFORE_KILL))
            return;

        Bytes.LOGGER.info( "going to kill cursors : " + sz );

        Map<ServerAddress,List<Long>> m = new HashMap<ServerAddress,List<Long>>();
        DeadCursor c;
        while (( c = _deadCursorIds.poll()) != null ){
            List<Long> x = m.get( c.host );
            if ( x == null ){
                x = new LinkedList<Long>();
                m.put( c.host , x );
            }
            x.add( c.id );
        }

        for ( Map.Entry<ServerAddress,List<Long>> e : m.entrySet() ){
            try {
                killCursors( e.getKey() , e.getValue() );
            }
            catch ( Throwable t ){
                Bytes.LOGGER.log( Level.WARNING , "can't clean cursors" , t );
                for ( Long x : e.getValue() )
                        _deadCursorIds.add( new DeadCursor( x , e.getKey() ) );
            }
        }
    }

    void killCursors( ServerAddress addr , List<Long> all ){
        if (Mongo.isClientModeEnabled()){
            return;
        }
        if ( all == null || all.size() == 0 )
            return;

        OutMessage om = OutMessage.killCursors(_mongo, Math.min( NUM_CURSORS_PER_BATCH , all.size()));

        int soFar = 0;
        int totalSoFar = 0;
        for (Long l : all) {
            om.writeLong(l);

            totalSoFar++;
            soFar++;

            if ( soFar >= NUM_CURSORS_PER_BATCH ){
                _connector.say( this , om ,com.mongodb.WriteConcern.NONE );
                om = OutMessage.killCursors(_mongo, Math.min( NUM_CURSORS_PER_BATCH , all.size() - totalSoFar));
                soFar = 0;
            }
        }

        _connector.say( this , om ,com.mongodb.WriteConcern.NONE , addr );
    }

    @Override
    CommandResult doAuthenticate(MongoCredential credentials) {
        return _connector.authenticate(credentials);
    }

    private boolean useUserCommands(final DBPort port) {
        return _connector.getServerDescription(port.getAddress()).getVersion().compareTo(new ServerVersion(2, 6)) >= 0;
    }

    void addDeadCursor(final DeadCursor deadCursor) {
        _deadCursorIds.add(deadCursor);
    }

    static class DeadCursor {

        DeadCursor( long a , ServerAddress b ){
            id = a;
            host = b;
        }

        final long id;
        final ServerAddress host;
    }

    final String _root;
    final String _rootPlusDot;
    final DBTCPConnector _connector;
    final ConcurrentHashMap<String,DBCollectionImpl> _collections = new ConcurrentHashMap<String,DBCollectionImpl>();

    ConcurrentLinkedQueue<DeadCursor> _deadCursorIds = new ConcurrentLinkedQueue<DeadCursor>();

}
