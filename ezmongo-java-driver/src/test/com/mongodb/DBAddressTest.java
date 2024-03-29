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

import com.mongodb.util.TestCase;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DBAddressTest extends TestCase {

    @Test
    public void testCTOR() 
        throws UnknownHostException {
        DBAddress foo = new DBAddress( "www.10gen.com:1000/some.host" );
        DBAddress bar = new DBAddress( foo, "some.other.host" );
        assertEquals( foo.sameHost( "www.10gen.com:1000" ), true );
        assertEquals( foo.getSocketAddress().hashCode(), bar.getSocketAddress().hashCode() );
    }

    @Test
    public void testInvalid() 
        throws UnknownHostException {
        boolean threw = false;
        try { 
            new DBAddress( null );
        }
        catch( NullPointerException e ) {
            threw = true;
        }
        assertTrue(threw);
        threw = false;

        try { 
            new DBAddress( "  \t\n" );
        }
        catch( IllegalArgumentException e ) {
            threw = true;
        }
        assertTrue(threw);
        threw = false;
    }

    @Test
    public void testBasics()
        throws UnknownHostException {
        assertEquals( 27017 , new ServerAddress().getPort() );
        assertEquals( 27017 , new ServerAddress( "localhost" ).getPort() );
        assertEquals( 9999 , new ServerAddress( "localhost:9999" ).getPort() );
    }

    @Test
    public void testCons3()
        throws UnknownHostException {
        DBAddress a = new DBAddress( "9.9.9.9:9999" , "abc" );
        assertEquals( "9.9.9.9" , a.getHost() );
        assertEquals( 9999 , a.getPort() );
        assertEquals( "abc" , a.getDBName() );
    }
 }

