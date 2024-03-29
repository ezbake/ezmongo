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

import org.bson.util.annotations.Immutable;

import java.io.Serializable;

import static org.bson.util.Assertions.isTrue;
import static org.bson.util.Assertions.notNull;

/**
 * The options to use for a parallel collection scan.
 *
 * @since 2.12
 */
@Immutable
public class ParallelScanOptions implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int numCursors;
    private final int batchSize;
    private final ReadPreference readPreference;

    /**
     * Create a builder for the options
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A builder for the options
     */
    public static class Builder {
        private int numCursors;
        private int batchSize;
        private ReadPreference readPreference;

        /**
         * Set the requested number of cursors to iterate in parallel.
         * <p>
         *     Note: this is the maximum number of cursors the server will return, it may return fewer cursors.
         * </p>
         *
         * @param numCursors the number of cursors requested, which must be >= 1 and <= 10000
         * @return this
         */
        public Builder numCursors(final int numCursors) {
            isTrue("numCursors >= 1", numCursors >= 1);
            isTrue("numCursors <= 10000", numCursors <= 10000);

            this.numCursors = numCursors;
            return this;
        }

        /**
         * The batch size to use for each cursor.
         *
         * @param batchSize the batch size, which must be >= 0
         * @return this
         */
        public Builder batchSize(final int batchSize) {
            isTrue("batchSize >= 0", batchSize >= 0);
            this.batchSize = batchSize;
            return this;
        }

        /**
         * The read preference to use.
         *
         * @param readPreference the read preference
         * @return this
         */
        public Builder readPreference(final ReadPreference readPreference) {
            this.readPreference = notNull("readPreference", readPreference);
            return this;
        }

        public ParallelScanOptions build() {
            return new ParallelScanOptions(this);
        }
    }

    /**
     * Gets the number of cursors requested.
     *
     * @return number of cursors requested.
     */
    public int getNumCursors() {
        return numCursors;
    }

    /**
     * Gets the batch size to use for each cursor.
     *
     * @return batch size
     */
    public int getBatchSize() {
        return batchSize;
    }

    /**
     * Gets the read preference to use.
     *
     * @return read preference
     */
    public ReadPreference getReadPreference() {
        return readPreference;
    }

    private ParallelScanOptions(final Builder builder) {
        numCursors = builder.numCursors;
        batchSize = builder.batchSize;
        readPreference = builder.readPreference;
    }

}
