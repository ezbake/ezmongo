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

// Response.java

package com.mongodb;

// Bson

import org.bson.io.Bits;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Java

public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    public Response( ServerAddress addr , DBCollection collection ,  InputStream in, DBDecoder decoder)
        throws IOException {

        _host = addr;

        final byte [] b = new byte[36];
        Bits.readFully(in, b);
        int pos = 0;

        _len = Bits.readInt(b, pos);
        pos += 4;

        if (_len > MAX_LENGTH) {
            throw new IllegalArgumentException( "response too long: " + _len );
        }

        _id = Bits.readInt(b, pos);
        pos += 4;

        _responseTo = Bits.readInt(b, pos);
        pos += 4;

        _operation = Bits.readInt(b, pos);
        pos += 4;

        _flags = Bits.readInt(b, pos);
        pos += 4;

        _cursor = Bits.readLong(b, pos);
        pos += 8;

        _startingFrom = Bits.readInt(b, pos);
        pos += 4;

        _num = Bits.readInt(b, pos);
        pos += 4;

        final MyInputStream user = new MyInputStream( in , _len - b.length );

        if ( _num < 2 )
            _objects = new LinkedList<DBObject>();
        else
            _objects = new ArrayList<DBObject>( _num );

        for ( int i=0; i < _num; i++ ){
            if ( user._toGo < 5 )
                throw new IOException( "should have more objects, but only " + user._toGo + " bytes left" );
            // TODO: By moving to generics, you can remove these casts (and requirement to impl DBOBject).

            _objects.add( decoder.decode( user, collection ) );
        }

        if ( user._toGo != 0 )
            throw new IOException( "finished reading objects but still have: " + user._toGo + " bytes to read!' " );

        if ( _num != _objects.size() )
            throw new RuntimeException( "something is really broken" );
    }

    public int size(){
        return _num;
    }

	public ServerAddress serverUsed() {
		return _host;
	}

    public DBObject get( int i ){
        return _objects.get(i);
    }

    public Iterator<DBObject> iterator(){
        return _objects.iterator();
    }

    public long cursor(){
        return _cursor;
    }

    public void setCursorId(long id){
        _cursor = id;
    }

    public ServerError getError(){
        if ( _num != 1 )
            return null;

        DBObject obj = get(0);

        if ( ServerError.getMsg( obj , null ) == null )
            return null;

        return new ServerError( obj );
    }

    static class MyInputStream extends InputStream {
        MyInputStream( InputStream in , int max ){
            _in = in;
            _toGo = max;
        }

        public int available()
            throws IOException {
            return _in.available();
        }

        public int read()
            throws IOException {

            if ( _toGo <= 0 )
                return -1;

            int val = _in.read();
            _toGo--;

            return val;
        }

        public int read(byte[] b, int off, int len)
            throws IOException {

            if ( _toGo <= 0 )
                return -1;

            int n = _in.read(b, off, Math.min(_toGo, len));
            _toGo -= n;
            return n;
        }

        public void close(){
            throw new RuntimeException( "can't close thos" );
        }

        final InputStream _in;
        private int _toGo;
    }

    public String toString(){
        return "flags:" + _flags + " _cursor:" + _cursor + " _startingFrom:" + _startingFrom + " _num:" + _num ;
    }

    transient final ServerAddress _host;

    final int _len;
    final int _id;
    final int _responseTo;
    final int _operation;

    final int _flags;
    long _cursor;
    final int _startingFrom;
    final int _num;

    List<DBObject> _objects;

    public List<DBObject> get_objects() {
        return _objects;
    }

    public void set_objects(List<DBObject> _objects) {
        this._objects = _objects;
    }

    private static final int MAX_LENGTH = ( 32 * 1024 * 1024 );
}
