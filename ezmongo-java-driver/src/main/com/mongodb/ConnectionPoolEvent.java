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

/**
 * A connection pool-related event.
 */
class ConnectionPoolEvent extends ClusterEvent {
    private final ServerAddress serverAddress;

    /**
     * Constructs a new instance of the event.
     *
     * @param clusterId     the cluster id
     * @param serverAddress the server address
     */

    public ConnectionPoolEvent(final String clusterId, final ServerAddress serverAddress) {
        super(clusterId);
        this.serverAddress = serverAddress;
    }

    /**
     * Gets the server address associated with this connection pool
     *
     * @return the server address
     */
    public ServerAddress getServerAddress() {
        return serverAddress;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ConnectionPoolEvent that = (ConnectionPoolEvent) o;

        if (!getClusterId().equals(that.getClusterId())) {
            return false;
        }
        if (!serverAddress.equals(that.serverAddress)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return 31 * result + serverAddress.hashCode();
    }
}