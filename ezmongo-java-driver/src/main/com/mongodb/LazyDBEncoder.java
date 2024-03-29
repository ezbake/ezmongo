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

import org.bson.BSONObject;
import org.bson.io.OutputBuffer;

import java.io.IOException;

/**
 * Encoder that only knows how to encode BSONObject instances of type LazyDBObject.
 */
public class LazyDBEncoder implements DBEncoder {
	
	/**
	 * @param buf
	 * @param o
	 * @return
	 * @throws MongoException
	 */
    @Override
    public int writeObject(final OutputBuffer buf, BSONObject o) {
        if (!(o instanceof LazyDBObject)) {
            throw new IllegalArgumentException("LazyDBEncoder can only encode BSONObject instances of type LazyDBObject");
        }

        LazyDBObject lazyDBObject = (LazyDBObject) o;

        try {
            lazyDBObject.pipe(buf);
        } catch (IOException e) {
            throw new MongoException("Exception serializing a LazyDBObject", e);
        }

        return lazyDBObject.getBSONSize();
    }
}
