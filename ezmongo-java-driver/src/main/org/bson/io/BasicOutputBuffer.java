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

// BasicOutputBuffer.java

package org.bson.io;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class BasicOutputBuffer extends OutputBuffer {

    @Override
    public void write(byte[] b){
        write( b , 0 , b.length );
    }

    @Override
    public void write(byte[] b, int off, int len){
        _ensure( len );
        System.arraycopy( b , off , _buffer , _cur , len );
        _cur += len;
        _size = Math.max( _cur , _size );
    }
    @Override
    public void write(int b){
        _ensure(1);
        _buffer[_cur++] = (byte)(0xFF&b);
        _size = Math.max( _cur , _size );
    }

    @Override
    public int getPosition(){
        return _cur;
    }

    /**
     * @deprecated This method is NOT a part of public API and will be dropped in 3.x versions.
     */
    @Override
    @Deprecated
    public void setPosition( int position ){
        _cur = position;
    }

    /**
     * @deprecated This method is NOT a part of public API and will be dropped in 3.x versions.
     */
    @Override
    @Deprecated
    public void seekEnd(){
        _cur = _size;
    }

    /**
     * @deprecated This method is NOT a part of public API and will be dropped in 3.x versions.
     */
    @Deprecated
    @Override
    public void seekStart(){
        _cur = 0;
    }

    /**
     * @return size of data so far
     */
    @Override
    public int size(){
        return _size;
    }

    /**
     * @return bytes written
     */
    @Override
    public int pipe( OutputStream out )
        throws IOException {
        out.write( _buffer , 0 , _size );
        return _size;
    }

    /**
     * @return bytes written
     * @deprecated This method is NOT a part of public API and will be dropped in 3.x versions.
     */
    @Deprecated
    public int pipe( DataOutput out )
        throws IOException {
        out.write( _buffer , 0 , _size );
        return _size;
    }


    void _ensure( int more ){
        final int need = _cur + more;
        if ( need < _buffer.length )
            return;

        int newSize = _buffer.length*2;
        if ( newSize <= need )
            newSize = need + 128;

        byte[] n = new byte[newSize];
        System.arraycopy( _buffer , 0 , n , 0 , _size );
        _buffer = n;
    }

    /**
     * @deprecated This method is NOT a part of public API and will be dropped in 3.x versions.
     */
    @Override
    @Deprecated
    public String asString(){
        return new String( _buffer , 0 , _size );
    }

    /**
     * @deprecated This method is NOT a part of public API and will be dropped in 3.x versions.
     */
    @Override
    @Deprecated
    public String asString( String encoding )
        throws UnsupportedEncodingException {
        return new String( _buffer , 0 , _size , encoding );
    }


    private int _cur;
    private int _size;
    private byte[] _buffer = new byte[512];
}
