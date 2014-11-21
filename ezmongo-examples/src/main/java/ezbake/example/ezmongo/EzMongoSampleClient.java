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

package ezbake.example.ezmongo;

import com.mongodb.*;
import ezbake.base.thrift.Visibility;
import ezbake.configuration.EzConfiguration;
import ezbake.configuration.EzConfigurationLoaderException;
import ezbake.configuration.constants.EzBakePropertyConstants;
import ezbake.data.common.classification.ClassificationUtils;
import ezbake.data.mongo.redact.RedactHelper;
import ezbake.data.mongo.thrift.EzMongoBaseException;
import org.apache.accumulo.core.security.VisibilityParseException;
import ezbake.classification.ClassificationConversionException;

import java.net.UnknownHostException;

/**
 * NOTE: Be sure to set the environment variable:
 * EZCONFIGURATION_DIR=src/main/resources
 * before running this class.
 * <p/>
 * NOTE: For packing & deploying to Production, your project would NOT include
 * this project's files under src/main/resources - specifically, the
 * ezbake-config.properties and the client directory.
 * They are here just for testing purposes.
 * <p/>
 * This is an example of using the ezmongo-java-driver.
 * You can use this as you would use the mongo-java-driver from 10gen.
 * By default, Client mode is enabled so that in the ezmongo-java-driver,
 * it will call out to the ezmongo thrift service when making database calls.
 * <p/>
 * You can also try running in non-Client (Service) mode, by uncommenting out the
 * "mongoClientMode=false" in the src/main/resources/ezbake-config.properties.
 * That will make it use the default Mongo API with the URI & database listed in the code below,
 * instead of hitting the ezmongo thrift service.
 * For non-Client mode, make sure to have "mongod" running on your local machine first.
 */
public class EzMongoSampleClient {

    private static final String DEFAULT_URI = "mongodb://localhost:27017";
    private static final String MONGODB_URI_SYSTEM_PROPERTY_NAME = "org.mongodb.test.uri";
    private static MongoClient staticMongoClient;
    private static MongoClientURI mongoClientURI;

    public static void main(String[] args) throws VisibilityParseException, ClassificationConversionException, EzMongoBaseException {

        init();

        DBObject helloWorld = new BasicDBObject("hello", "world");
        DBObject objToInsert = new BasicDBObject("text", helloWorld);

        // Here, we would insert the security tagging fields into the DBObject by calling a utility class (RedactHelper.java).
        Visibility vis = new Visibility();
        // Convert CAPCO to Accumulo-style boolean expression string and set it in the Visibility object.
        String booleanExpressionString = ClassificationUtils.getAccumuloVisibilityStringFromCAPCO("SECRET");
        vis.setFormalVisibility(booleanExpressionString);
        RedactHelper.setSecurityFieldsInDBObject(objToInsert, vis, "testAppId");

        // Call the Provenance service to get a unique ID for the document -
        //   the unique ID would be used for the Purge feature.


        // Get the mongo database & collection
        DB db = null;
        try {
            db = getDatabase("testdb");
        } catch (EzConfigurationLoaderException e) {
            e.printStackTrace();
        }
        DBCollection collection = db.getCollection("testCollection1");

        // Save to MongoDB
        collection.save(objToInsert);

        // Retrieve from Mongo
        DBCursor cursor = collection.find(objToInsert);
        if (cursor.hasNext()) {
            DBObject obj = cursor.next();
            System.out.println("obj: " + obj);
        }
    }

    private static void init() {
        try {
            staticMongoClient = new MongoClient(getMongoClientURI());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized MongoClientURI getMongoClientURI() {
        if (mongoClientURI == null) {
            String mongoURIProperty = System.getProperty(MONGODB_URI_SYSTEM_PROPERTY_NAME);
            String mongoURIString = mongoURIProperty == null || mongoURIProperty.isEmpty() ? DEFAULT_URI : mongoURIProperty;
            mongoClientURI = new MongoClientURI(mongoURIString);
        }
        return mongoClientURI;
    }

    protected static DB getDatabase(String dbName) throws EzConfigurationLoaderException {
        if (Mongo.isClientModeEnabled()) {
            // For reference - look at src/main/resources/ezbake-config.properties file that has the "application.name" property
            // For testing purposes, you can create a new EzConfiguration(new ClasspathConfigurationLoader())
            //   to read the ezconfig properties file from the classpath, so you don't have to set the EZCONFIGURATION_DIR env variable.
            return staticMongoClient.getDB(new EzConfiguration().getProperties().
                    getProperty(EzBakePropertyConstants.EZBAKE_APPLICATION_NAME));
        } else {
            return staticMongoClient.getDB(dbName);
        }
    }
}
