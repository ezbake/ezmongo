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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
public class MongoCredentialTest extends TestCase {

    @Test
    public void testCredentials() {
        MongoCredential credentials;

        final String mechanism = MongoCredential.MONGODB_CR_MECHANISM;
        final String userName = "user";
        final String database = "test";
        final char[] password = "pwd".toCharArray();
        credentials = MongoCredential.createMongoCRCredential(userName, database, password);

        assertEquals(mechanism, credentials.getMechanism());
        assertEquals(userName, credentials.getUserName());
        assertEquals(database, credentials.getSource());
        assertArrayEquals(password, credentials.getPassword());
        assertEquals(MongoCredential.MONGODB_CR_MECHANISM, credentials.getMechanism());

        try {
            MongoCredential.createMongoCRCredential(userName, database, null);
            fail("MONGO-CR must have a password");
        } catch (IllegalArgumentException e) {
            // all good
        }
    }

    @Test
    public void testCredentialsStore() {
        char[] password = "pwd".toCharArray();
        MongoCredentialsStore store;

        store = new MongoCredentialsStore();
        assertTrue(store.getDatabases().isEmpty());
        assertNull(store.get("test"));

        store = new MongoCredentialsStore((MongoCredential) null);
        assertTrue(store.getDatabases().isEmpty());
        assertNull(store.get("test"));

        MongoCredential credentials = MongoCredential.createMongoCRCredential("user", "admin", password);
        store = new MongoCredentialsStore(credentials);
        Set<String> expected;
        expected = new HashSet<String>();
        expected.add("admin");
        assertEquals(expected, store.getDatabases());
        assertEquals(credentials, store.get("admin"));
        assertNull(store.get("test"));

        List<MongoCredential> credentialsList;

        final MongoCredential credentials1 = MongoCredential.createMongoCRCredential("user", "db1", password);
        final MongoCredential credentials2 = MongoCredential.createMongoCRCredential("user", "db2", password);
        credentialsList = Arrays.asList(credentials1, credentials2);
        store = new MongoCredentialsStore(credentialsList);
        expected = new HashSet<String>();
        expected.add("db1");
        expected.add("db2");
        assertEquals(expected, store.getDatabases());
        assertEquals(credentials1, store.get("db1"));
        assertEquals(credentials2, store.get("db2"));
        assertNull(store.get("db3"));
        assertEquals(credentialsList, store.asList());

        credentialsList = Arrays.asList(credentials1, MongoCredential.createMongoCRCredential("user2", "db1", password));
        try {
            new MongoCredentialsStore(credentialsList);
            fail("should throw");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void testMechanismPropertyDefaulting() {
        // given
        String firstKey = "firstKey";
        MongoCredential credential = MongoCredential.createGSSAPICredential("user");

        // then
        assertEquals("mongodb", credential.getMechanismProperty(firstKey, "mongodb"));
    }

    @Test
    public void testMechanismPropertyMapping() {
        // given
        String firstKey = "firstKey";
        String firstValue = "firstValue";
        String secondKey = "secondKey";
        Integer secondValue = 2;

        // when
        MongoCredential credential = MongoCredential.createGSSAPICredential("user").withMechanismProperty(firstKey, firstValue);

        // then
        assertEquals(firstValue, credential.getMechanismProperty(firstKey, "default"));

        // when
        credential = credential.withMechanismProperty(secondKey, secondValue);

        // then
        assertEquals(firstValue, credential.getMechanismProperty(firstKey, "default"));
        assertEquals(secondValue, credential.getMechanismProperty(secondKey, 1));
    }
    @Test
    public void testPlainMechanism() {
        MongoCredential credential;

        final String mechanism = MongoCredential.PLAIN_MECHANISM;
        final String userName = "user";
        final char[] password = "pwd".toCharArray();
        final String source = "$external";
        credential = MongoCredential.createPlainCredential(userName, source, password);

        assertEquals(mechanism, credential.getMechanism());
        assertEquals(userName, credential.getUserName());
        assertEquals("$external", credential.getSource());
        assertArrayEquals(password, credential.getPassword());
    }

    @Test
    public void testX509Mechanism() {
        MongoCredential credential;

        final String mechanism = MongoCredential.MONGODB_X509_MECHANISM;
        final String userName = "user";
        credential = MongoCredential.createMongoX509Credential(userName);

        assertEquals(mechanism, credential.getMechanism());
        assertEquals(userName, credential.getUserName());
        assertEquals("$external", credential.getSource());
        assertArrayEquals(null, credential.getPassword());
    }
}
