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

// DBPointer.java

package com.mongodb;

import org.bson.types.ObjectId;

/**
 * @deprecated BSON type DBPointer(0x0c) is deprecated. Please use a {@link com.mongodb.DBRef} instead.
 */
@Deprecated
public class DBPointer extends DBRefBase {
    
    private static final long serialVersionUID = -1977838613745447826L;

    /**
     *  CTOR used for testing BSON encoding.  Otherwise
     *  non-functional due to a DBRef needing a parent db object,
     *  a fieldName and a db
     *
     * @param ns namespace to point to
     * @param id value of _id
     */
    public DBPointer(String ns, ObjectId id) {
        this (null, null, null, ns, id);
    }

    DBPointer( DBObject parent , String fieldName , DB db , String ns , ObjectId id ){
        super(db, ns, id);
    
        _parent = parent;
        _fieldName = fieldName;
    }

    public String toString(){
        return "{ \"$ref\" : \"" + _ns + "\", \"$id\" : ObjectId(\"" + _id + "\") }";
    }

    public ObjectId getId() {
        return (ObjectId)_id;
    }

    final DBObject _parent;
    final String _fieldName;
}
