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

package com.mongodb.util;

import com.mongodb.*;
import ezbake.configuration.EzConfiguration;
import ezbake.configuration.EzConfigurationLoaderException;
import ezbakehelpers.ezconfigurationhelpers.mongo.MongoConfigurationHelper;
import org.junit.Before;
import org.junit.BeforeClass;

import java.net.UnknownHostException;
import java.util.List;

import static org.junit.Assume.assumeTrue;

public class TestCase {

    public static final String DEFAULT_URI = "mongodb://localhost:27017";
    public static final String MONGODB_URI_SYSTEM_PROPERTY_NAME = "org.mongodb.test.uri";
    private static MongoClientURI mongoClientURI;

    public TestCase(){
        cleanupMongo = staticMongoClient;
    }

    private static final String cleanupDB = "mongo-java-driver-test";
    public Mongo cleanupMongo = null;
    protected DBCollection collection;
    protected static MongoConfigurationHelper mongoConfigurationHelper;

    private static MongoClient staticMongoClient;

    public static synchronized MongoClientURI getMongoClientURI() {
        if (mongoClientURI == null) {
            String mongoURIProperty = System.getProperty(MONGODB_URI_SYSTEM_PROPERTY_NAME);
            String mongoURIString = mongoURIProperty == null || mongoURIProperty.isEmpty() ? DEFAULT_URI : mongoURIProperty;
            mongoClientURI = new MongoClientURI(mongoURIString);
        }
        return mongoClientURI;
    }

    @BeforeClass
    public static void testCaseBeforeClass() throws EzConfigurationLoaderException {
        if (staticMongoClient == null) {
            try {
                staticMongoClient = new MongoClient(getMongoClientURI());

                if (Mongo.isClientModeEnabled()){
                    mongoConfigurationHelper = new MongoConfigurationHelper(new EzConfiguration().getProperties());
                    staticMongoClient.dropDatabase(mongoConfigurationHelper.getMongoDBDatabaseName());
                } else {
                    staticMongoClient.dropDatabase(cleanupDB);
                }

                Runtime.getRuntime().addShutdownHook(new ShutdownHook());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Before
    public void testCaseBefore() throws EzConfigurationLoaderException {
        collection = getDatabase().getCollection(getClass().getName());
        collection.drop();
    }

    static class ShutdownHook extends Thread {
        @Override
        public void run() {
            if (staticMongoClient != null) {

                if (Mongo.isClientModeEnabled()){
                    staticMongoClient.dropDatabase(mongoConfigurationHelper.getMongoDBDatabaseName());
                } else {
                    staticMongoClient.dropDatabase(cleanupDB);
                }

                staticMongoClient.close();
                staticMongoClient = null;
            }
        }
    }

    protected static MongoClient getMongoClient() {
        return staticMongoClient;
    }

    protected static DB getDatabase() {
        if (Mongo.isClientModeEnabled()){
            return staticMongoClient.getDB(mongoConfigurationHelper.getMongoDBDatabaseName());
        } else {
            return staticMongoClient.getDB(cleanupDB);
        }
    }

    /**
     *
     * @param version  must be a major version, e.g. 1.8, 2,0, 2.2
     * @return true if server is at least specified version
     */
    protected boolean serverIsAtLeastVersion(double version) {
        return serverIsAtLeastVersion(version, cleanupMongo);
    }

    protected boolean serverIsAtLeastVersion(double version, Mongo mongo) {
        String serverVersion = (String) mongo.getDB("admin").command("serverStatus").get("version");
        return Double.parseDouble(serverVersion.substring(0, 3)) >= version;
    }

    protected void checkServerVersion(double version) {
        assumeTrue(serverIsAtLeastVersion(version));
    }

    /**
     *
     * @param mongo the connection
     * @return true if connected to a standalone server
     */
    protected static boolean isStandalone(Mongo mongo) {
        return !isReplicaSet(mongo) && !isSharded(mongo);
    }

    protected static boolean isReplicaSet(Mongo mongo) {
        return runIsMaster(mongo).get("setName") != null;
    }

    protected static boolean isSharded(Mongo mongo) {
        CommandResult isMasterResult = runIsMaster(mongo);
        Object msg = isMasterResult.get("msg");
        return msg != null && msg.equals("isdbgrid");
    }

    @SuppressWarnings({"unchecked"})
    protected String getPrimaryAsString(Mongo mongo) {
        return getMemberNameByState(mongo, "primary");
    }

    @SuppressWarnings({"unchecked"})
    protected String getASecondaryAsString(Mongo mongo) {
        return getMemberNameByState(mongo, "secondary");
    }

    protected void enableMaxTimeFailPoint() {
        if (Mongo.isClientModeEnabled()){
            //cleanupMongo.getDB(new EZConfiguration().get("application.name")).command(new BasicDBObject("configureFailPoint", "maxTimeAlwaysTimeOut").append("mode", "alwaysOn"),
            //        0, ReadPreference.primary());
        } else {
            cleanupMongo.getDB("admin").command(new BasicDBObject("configureFailPoint", "maxTimeAlwaysTimeOut").append("mode", "alwaysOn"),
                    0, ReadPreference.primary());
        }
    }

    protected void disableMaxTimeFailPoint() {
        if (serverIsAtLeastVersion(2.5)) {
            if (Mongo.isClientModeEnabled()){
                //cleanupMongo.getDB(new EZConfiguration().get("application.name")).command(new BasicDBObject("configureFailPoint", "maxTimeAlwaysTimeOut").append("mode", "off"),
                //        0, ReadPreference.primary());
            } else {
                cleanupMongo.getDB("admin").command(new BasicDBObject("configureFailPoint", "maxTimeAlwaysTimeOut").append("mode", "off"),
                        0, ReadPreference.primary());
            }
        }
    }


    @SuppressWarnings({"unchecked"})
    protected String getMemberNameByState(Mongo mongo, String stateStrToMatch) {
        CommandResult replicaSetStatus = runReplicaSetStatusCommand(mongo);

        for (final BasicDBObject member : (List<BasicDBObject>) replicaSetStatus.get("members")) {
            String hostnameAndPort = member.getString("name");
            if (!hostnameAndPort.contains(":"))
                hostnameAndPort = hostnameAndPort + ":27017";

            final String stateStr = member.getString("stateStr");

            if (stateStr.equalsIgnoreCase(stateStrToMatch))
                return hostnameAndPort;
        }

        throw new IllegalStateException("No member found in state " + stateStrToMatch);
    }

    @SuppressWarnings("unchecked")
    protected int getReplicaSetSize(Mongo mongo) {
        int size = 0;

        CommandResult replicaSetStatus = runReplicaSetStatusCommand(mongo);

        for (final BasicDBObject member : (List<BasicDBObject>) replicaSetStatus.get("members")) {

            final String stateStr = member.getString("stateStr");

            if (stateStr.equals("PRIMARY") || stateStr.equals("SECONDARY"))
                size++;
        }

        return size;
    }

    
    protected static CommandResult runReplicaSetStatusCommand(final Mongo pMongo) {
        // Check to see if this is a replica set... if not, get out of here.
        final CommandResult result = pMongo.getDB("admin").command(new BasicDBObject("replSetGetStatus", 1));

        final String errorMsg = result.getErrorMessage();

        if (errorMsg != null && errorMsg.indexOf("--replSet") != -1) {
            System.err.println("---- SecondaryReadTest: This is not a replica set - not testing secondary reads");
            return null;
        }

        return result;
    }

    protected static CommandResult runIsMaster(final Mongo pMongo) {
        // Check to see if this is a replica set... if not, get out of here.
        return pMongo.getDB("admin").command(new BasicDBObject("ismaster", 1));
    }
}
