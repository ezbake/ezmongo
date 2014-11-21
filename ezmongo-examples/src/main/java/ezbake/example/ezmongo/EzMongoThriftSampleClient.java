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

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import ezbake.base.thrift.AdvancedMarkings;
import ezbake.base.thrift.EzSecurityToken;
import ezbake.base.thrift.PlatformObjectVisibilities;
import ezbake.base.thrift.Visibility;
import ezbake.configuration.EzConfiguration;
import ezbake.configuration.EzConfigurationLoaderException;
import ezbake.data.common.classification.ClassificationUtils;
import ezbake.data.mongo.thrift.EzMongo;
import ezbake.data.mongo.thrift.MongoEzbakeDocument;
import ezbake.security.client.EzbakeSecurityClient;
import ezbake.thrift.ThriftClientPool;
import org.apache.thrift.TException;
import ezbake.classification.ClassificationConversionException;

import java.util.Properties;

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
 * This is an example of calling the ezmongo thrift service directly,
 * similar to how the Mongo Dataset worked in release 1.3.
 * <p/>
 */
public class EzMongoThriftSampleClient {

    private static MongoClient staticMongoClient;
    private static MongoClientURI mongoClientURI;
    private static ThriftClientPool pool;
    private static EzbakeSecurityClient securityClient;
    private static Properties properties;

    public static void main(String[] args) throws TException, ClassificationConversionException {

        init();

        DBObject helloWorld = new BasicDBObject("hello", "world");
        DBObject objToInsert = new BasicDBObject("text", helloWorld);

        EzSecurityToken token = securityClient.fetchTokenForProxiedUser();

        // MongoEzbakeDocument thrift object contains the JSON document & Visibility to insert.
        // Please see: ezmongo/ezmongo-thrift/src/main/thrift/ezMongo.thrift
        MongoEzbakeDocument doc = new MongoEzbakeDocument();
        doc.setJsonDocument(objToInsert.toString());

        // "Visibility" is the new thrift object used for security tagging.
        // It has replaced DocumentClassification from release 1.3.
        // Please see: ezbake-base-thrift/src/main/thrift/ezbakeBaseVisibility.thrift
        Visibility vis = new Visibility();
        // "Formal Visibility" field would contain the Accumulo-style boolean expression.
        // Convert CAPCO to Accumulo-style boolean expression string and set it in the Visibility object.
        String booleanExpressionString = ClassificationUtils.getAccumuloVisibilityStringFromCAPCO("SECRET");
        vis.setFormalVisibility(booleanExpressionString);
        // "AdvancedMarkings" is used to set externalCommunityVisibility & PlatformObjectVisibilities (Read/Write/Discover/Manage permissions).
        //    Delete, insert, and changes to non "_ez" (security tagging) fields within the data should be scoped by Write permission.
        //    Modifications to "_ez" parameters of an existing document should be scoped by Manage.
        //    These values are represented by groupId's returned from the EzGroups service.
        AdvancedMarkings advancedMarkings = new AdvancedMarkings();
        //advancedMarkings.setExternalCommunityVisibility("U");
        PlatformObjectVisibilities platformObjectVisibilities = new PlatformObjectVisibilities();
        // Here, we would call the EzGroups service and get the groupIds to set in the Read/Write/Discover/Manage as needed.
        //platformObjectVisibilities.setPlatformObjectReadVisibility(new HashSet<Long>()); // set the groupIds as Set<Long>
        advancedMarkings.setPlatformObjectVisibility(platformObjectVisibilities);

        // Here, we would call the Provenance service to get a unique ID for the document -
        //   the unique ID would be used for the Purge feature.
        // Below are Purge-related fields.
        //advancedMarkings.setId(idFromProvenance);
        //advancedMarkings.setComposite(false);
        vis.setAdvancedMarkings(advancedMarkings);
        doc.setVisibility(vis);

        // Do some inserts using ezmongo thrift service
        for (int i = 1; i <= 10; i++) {
            EzMongo.Client client = getThriftClient();
            client.insert("testCollection1", doc, token);
            //client.ping();
            System.out.println("inserted count: " + i);

            pool.returnToPool(client);
        }

        System.out.println("Done.");
    }

    private static EzMongo.Client getThriftClient() throws TException {
        return pool.getClient("ezmongo", EzMongo.Client.class);
    }

    private static void init() {

        try {
            // Note that for testing purposes, you can create a new EzConfiguration(new ClasspathConfigurationLoader())
            //   to read the ezconfig properties file from the classpath, so you don't have to set the EZCONFIGURATION_DIR env variable.
            properties = new EzConfiguration().getProperties();
            if (securityClient == null) {
                securityClient = new EzbakeSecurityClient(properties);
            }
            if (pool == null) {
                pool = new ThriftClientPool(properties);
            }

        } catch (EzConfigurationLoaderException e) {
            e.printStackTrace();
        }
    }

}
