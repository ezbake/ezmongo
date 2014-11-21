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

package com.mongodb;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jagius on 6/4/14.
 */
public class EzResponse extends Response {
/*
    EzResponse(List<DBObject> objects){
        super();
        addDBObjects(objects);
    }
*/

    EzResponse(ServerAddress addr, DBCollection collection, InputStream in, DBDecoder decoder) throws IOException {
        super(addr, collection, in, decoder);
    }

    void addDBObjects(List<DBObject> objs){
        for (DBObject o : objs) {
            _objects.add(o);
        }
    }
}
