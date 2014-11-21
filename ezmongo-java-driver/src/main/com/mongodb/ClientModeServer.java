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

import java.util.concurrent.TimeUnit;

/**
 * Created by jagius on 6/9/14.
 */
public class ClientModeServer implements ClusterableServer {
    /**
     * Gets the description of this server.  Implementations of this method should not block if the server has not yet been successfully
     * contacted, but rather return immediately a @code{ServerDescription} in a @code{ServerDescription.Status.Connecting} state.
     *
     * @return the description of this server
     */
    @Override
    public ServerDescription getDescription() {
        return ServerDescription.builder().build();
    }

    @Override
    public Connection getConnection(long maxWaitTime, TimeUnit timeUnit) {
        return null;
    }

    /**
     * Adds a change listener to this server.
     *
     * @param changeListener the listener for change events to the description of this server
     */
    @Override
    public void addChangeListener(ChangeListener<ServerDescription> changeListener) {

    }

    @Override
    public void invalidate() {

    }

    /**
     * Closes the server.  Instances that have been closed will no longer be available for use.
     * <p>
     * Implementations should ensure that this method can be called multiple times with no ill effects.
     * </p>
     */
    @Override
    public void close() {

    }

    /**
     * Returns true if the server is closed, false otherwise.
     * <p/>
     * * @return whether the server is closed
     */
    @Override
    public boolean isClosed() {
        return false;
    }

    private volatile ServerDescription description;
}
