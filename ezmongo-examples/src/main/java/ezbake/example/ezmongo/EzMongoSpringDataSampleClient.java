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

import ezbake.base.thrift.Visibility;
import ezbake.data.common.classification.ClassificationUtils;
import ezbake.data.mongo.redact.RedactHelper;
import ezbake.data.mongo.thrift.EzMongoBaseException;
import ezbake.example.ezmongo.springData.Name;
import ezbake.example.ezmongo.springData.User;
import org.apache.accumulo.core.security.VisibilityParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ezbake.classification.ClassificationConversionException;

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
 * NOTE: The markings.config file is on the classpath (src/main/resources) of this project -
 * it has the DerivedFromMarking check disabled.
 * If a markings.config file is not provided on the classpath or by an EzConfiguration property
 * "markings.path"
 * <p/>
 * This is an example of using Spring Data with the ezmongo-java-driver.
 * You can use this as you would use the regular Spring Data.
 * By default, Client mode is enabled so that in the ezmongo-java-driver,
 * it will call out to the ezmongo thrift service when making database calls.
 * <p/>
 * NOTE: Your POJO model classes should inherit from ezbake.data.mongo.EzMongoBasePojo -
 * refer to the User.java in this project for an example.
 * <p/>
 * You can also try running in non-Client mode, by uncommenting out the
 * "mongoClientMode=false" in the src/main/resources/ezbake-config.properties.
 * That will make it use the default Mongo API with the URI & database listed in the code below,
 * instead of hitting the ezmongo thrift service.
 * For non-Client mode, make sure to have "mongod" running on your local machine first.
 */
public class EzMongoSpringDataSampleClient {

    public static void main(String[] args) throws VisibilityParseException, ClassificationConversionException, EzMongoBaseException {

        // For XML
        ApplicationContext ctx = new GenericXmlApplicationContext("springDataConfig.xml");

        // For Annotation
        //ApplicationContext ctx =
        //        new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        User user = new User("mkyong", "password123");

        // Here, we would insert the security tagging fields into the DBObject by calling a utility class (RedactHelper.java).
        Visibility vis = new Visibility();
        // Convert CAPCO to Accumulo-style boolean expression string and set it in the Visibility object.
        String booleanExpressionString = ClassificationUtils.getAccumuloVisibilityStringFromCAPCO("SECRET");
        vis.setFormalVisibility(booleanExpressionString);
        RedactHelper.setSecurityFieldsInDBObject(user, vis, "testAppId");

        // Also set the Name field in the User
        Name name = new Name("testFirstName", "testLastName");
        Visibility nameVis = new Visibility();
        nameVis.setFormalVisibility(booleanExpressionString);
        RedactHelper.setSecurityFieldsInDBObject(name, nameVis, "testAppId");

        user.setName(name);

        // Call the Provenance service to get a unique ID for the document -
        //   the unique ID would be used for the Purge feature.

        // save
        mongoOperation.save(user);

        // now user object got the created id.
        System.out.println("1. user : " + user);

        // query to search user
        Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

        // find the saved user again.
        User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
        System.out.println("2. find - savedUser : " + savedUser);

    }

}
