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

package example;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;

import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * An example of using a MongoClient in a multi-threaded environment.
 *
 * It runs in a console until Ctrl-C.  It takes an optional command line argument for the URI to use to connect.
 */
public class MultiThreadedExample {

    public static final int NUM_DOCUMENTS = 10000;
    public static final int NUM_THREADS = 100;

    public static void main(String[] args) throws UnknownHostException {
        MongoClientURI uri = args.length > 0
                             ? new MongoClientURI(args[0])
                             : new MongoClientURI("mongodb://localhost");
        MongoClient mongoClient = new MongoClient(uri);

        DB db = mongoClient.getDB(uri.getDatabase() != null
                                  ? uri.getDatabase()
                                  : "test");

        final DBCollection collection = db.getCollection("test");
        collection.drop();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    while (true) {
                        int i = random.nextInt(NUM_DOCUMENTS);
                        try {
                            DBObject document = collection.find(new BasicDBObject("i", i))
                                                          .setReadPreference(ReadPreference.secondaryPreferred())
                                                          .one();
                            if (document == null) {
                                collection.insert(new BasicDBObject("i", i));
                            } else {
                                collection.update(new BasicDBObject("_id", document.get("_id")),
                                                  new BasicDBObject("$set", new BasicDBObject("i", i + 1)));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
