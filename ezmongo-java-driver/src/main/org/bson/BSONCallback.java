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

// BSONCallback.java

package org.bson;

import org.bson.types.ObjectId;

public interface BSONCallback {
    
    void objectStart();
    void objectStart(String name);
    void objectStart(boolean array);
    Object objectDone();

    void reset();
    Object get();
    BSONCallback createBSONCallback();

    void arrayStart();
    void arrayStart(String name);
    Object arrayDone();
    
    void gotNull( String name );
    void gotUndefined( String name );
    void gotMinKey( String name );
    void gotMaxKey( String name );
    
    void gotBoolean( String name , boolean v );
    void gotDouble( String name , double v );
    void gotInt( String name , int v );
    void gotLong( String name , long v );
    
    void gotDate( String name , long millis );
    void gotString( String name , String v );
    void gotSymbol( String name , String v );
    void gotRegex( String name , String pattern , String flags );

    void gotTimestamp( String name , int time , int inc );
    void gotObjectId( String name , ObjectId id );

    /**
     * Invoked when {@link org.bson.BSONDecoder} encountered a DBPointer(0x0c) type field in a byte sequence.
     *
     * @param name the name of the field
     * @param ns   the namespace to which reference is pointing to
     * @param id   the if of the object to which reference is pointing to
     */
    void gotDBRef(String name, String ns, ObjectId id);
    
    /**
     * 
     */
    @Deprecated
    void gotBinaryArray( String name , byte[] data );
    void gotBinary( String name , byte type , byte[] data );
    /**
     * subtype 3
     */
    void gotUUID( String name , long part1, long part2);

    void gotCode( String name , String code );
    void gotCodeWScope( String name , String code , Object scope );
}
