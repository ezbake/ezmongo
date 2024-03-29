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

import org.bson.LazyBSONCallback;
import org.bson.LazyBSONObject;
import org.bson.io.BSONByteBuffer;

public class LazyDBObject extends LazyBSONObject implements DBObject {

	public void markAsPartialObject() {
	_partial = true;
    }

    public boolean isPartialObject() {
        return _partial;
    }

    public LazyDBObject(BSONByteBuffer buff, LazyBSONCallback cbk){ 
        super(buff, cbk);
    }

    public LazyDBObject(BSONByteBuffer buff, int offset, LazyBSONCallback cbk){ 
        super(buff, offset, cbk);
    }

    
    public LazyDBObject(byte[] data, LazyBSONCallback cbk){
        this(data, 0, cbk);
    }

    public LazyDBObject(byte[] data, int offset, LazyBSONCallback cbk){
        super(data, offset, cbk);
    }

    private boolean _partial = false;
}
