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

// ObjectIdTest.java

package com.mongodb;

import com.mongodb.util.TestCase;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

public class ObjectIdTest extends TestCase {

    @Test
    public void testRT1(){
        ObjectId a = new ObjectId();
        assertEquals( a.toStringBabble() , (new ObjectId( a.toStringBabble() , true ) ).toStringBabble() );
        assertEquals( a.toStringMongod() , (new ObjectId( a.toStringMongod() , false ) ).toStringMongod() );
        assertEquals( a.toStringMongod() , (new ObjectId( a.toStringMongod() ) ).toStringMongod() );
        assertEquals( a.toString() , (new ObjectId( a.toString() , false ) ).toString() );
    }

    @Test
    public void testBabbleToMongo(){
        ObjectId a = new ObjectId();
        assertEquals( a.toStringMongod() , ObjectId.babbleToMongod( a.toStringBabble() ) );
    }

    @Test
    public void testBytes(){
        ObjectId a = new ObjectId();
        assertEquals( a , new ObjectId( a.toByteArray() ) );
        
        byte b[] = new byte[12];
        java.util.Random r = new java.util.Random( 17 );
        for ( int i=0; i<b.length; i++ )
            b[i] = (byte)(r.nextInt());
        a = new ObjectId( b );
        assertEquals( a , new ObjectId( a.toByteArray() ) );        
        assertEquals( "41d91c58988b09375cc1fe9f" , a.toString() );
    }

    @Test
    public void testTime(){
        long a = System.currentTimeMillis();
        long b = (new ObjectId()).getTime();
        assertTrue( Math.abs( b - a ) < 3000 );
    }

    @Test
    public void testBasics(){
        ObjectId a = new ObjectId();
        ObjectId b = new ObjectId();
        assertNotEquals( a , b );
    }
    
    @Test
    public void testDateCons(){
        java.util.Date d = new java.util.Date();
        ObjectId a = new ObjectId( d );
        assertEquals( d.getTime() / 1000 , a.getTime() / 1000 );
    }

    @Test
    public void testStringOnServer(){
        assumeFalse(isSharded(getMongoClient()));

        ObjectId oid = new ObjectId();
        DBObject res = getDatabase().command( new BasicDBObject( "driverOIDTest" , oid ) );
        assertEquals( oid.toString() , res.get( "str" ).toString() );
    }

    void _testFlip( int x , int Y ){
        int y = ObjectId._flip( x );
        int z = ObjectId._flip( y );
        assertEquals( x , z );
        if ( Y > 0 )
            assertEquals( Y , y );
    }

    @Test
    public void testFlip(){

        _testFlip( 1 , 16777216 );
        _testFlip( 1231231 , 2143883776 );
        _testFlip( 0x12345678 , 0x78563412 );
        
        Random r = new Random( 12312312 );
        for ( int i=0; i<1000; i++ ){
            int x = r.nextInt();
            _testFlip( r.nextInt() , 0 );
        }
        
    }

    /**
     * Test that within same second, increment value correctly generates ordered ids
     */
    @Test
    public void testInc() {
        ObjectId prev = null;
        Date now = new Date();
        // need to loop more than value of byte, to check that endianness is correct
        for (int i = 0; i < 1000; ++i) {
            ObjectId id = new ObjectId(now);
            assertEquals(id.getTime() / 1000, now.getTime() / 1000);
            if (prev != null) {
                assertTrue(prev.compareTo(id) < 0);
            }
            prev = id;
        }
    }

    @Test
    public void testCreateFromLegacyFormat() {
        ObjectId id = new ObjectId();
        assertEquals(id, ObjectId.createFromLegacyFormat(id.getTimeSecond(), id.getMachine(), id.getInc()));
    }
}
