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

abstract class ModifyRequest extends WriteRequest {
    private final DBObject query;
    private final boolean upsert;
    private final DBObject updateDocument;

    public ModifyRequest(final DBObject query, final boolean upsert, final DBObject updateDocument) {
        this.query = query;
        this.upsert = upsert;
        this.updateDocument = updateDocument;
    }

    public DBObject getQuery() {
        return query;
    }

    public boolean isUpsert() {
        return upsert;
    }

    public DBObject getUpdateDocument() {
        return updateDocument;
    }

    public boolean isMulti() {
        return false;
    }
}
