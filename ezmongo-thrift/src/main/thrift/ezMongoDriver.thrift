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

namespace java ezbake.data.mongo.driver.thrift

include "ezbakeBaseTypes.thrift"
include "ezMongo.thrift"

struct EzInsertRequest {
    1:binary dbObjectList,
    2:binary writeConcern,
    3:binary dbEncoder;
    4:bool isUnitTestMode;
}

struct EzUpdateRequest {
    1:binary query,
    2:binary dbUpdateObject,
    3:bool upsert,
    4:bool multi,
    5:binary writeConcern,
    6:binary dbEncoder;
    7:bool isUnitTestMode;
}

struct EzCreateIndexRequest {
    1:binary dbObjectKeys,
    2:binary dbObjectOptions,
    3:binary dbEncoder;
}

struct EzFindRequest {
    1:binary ref,
    2:binary fields,
    3:i32 numToSkip,
    4:i32 batchSize,
    5:i32 limit,
    6:i32 options,
    7:binary readPref,
    8:binary decoder;
    9:binary encoder;
    10:string collection;
}

struct EzAggregationRequest {
    1:binary pipeline, //in Java: List<DBObject>
    2:binary options, //AggregationOptions
    3:binary readPref; //ReadPreference 
}

struct EzWriteResult {
    1:binary writeResult,
    2:optional binary mongoexception;
}

struct ResultsWrapper {
    1:string requestId,
    2:binary resultSet,
    3:binary responseData,
    4:bool resultSetValid,
    5:i16 rowsEffected,
    6:optional binary mongoexception;
}

struct EzGetMoreRequest {
    1:binary outmessage,
    2:binary decoder;
    3:string queryResultIteratorHashcode;
}

struct EzRemoveRequest {
        1:binary dbObjectQuery,
        2:binary writeConcern,
        3:binary dbEncoder;
}

struct EzGetMoreResponse {
    1:binary response,
    2:binary resultSet,
    3:optional binary mongoexception;
}

struct EzParallelScanResponse {
    1:binary listOfCursors,
    2:binary mapOfIterators;
}

struct EzParallelScanOptions {
    1:binary options;
}

exception EzMongoDriverException 
{
    1:binary ex;
}

service EzMongoDriverService extends ezMongo.EzMongo
{
    bool authenticate_driver(1:ezbakeBaseTypes.EzSecurityToken security);
    ResultsWrapper find_driver(1:string collection, 2:EzFindRequest request, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    ResultsWrapper aggregate_driver(1:string collection, 2:EzAggregationRequest request, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    EzWriteResult insert_driver(1:string collection, 2:EzInsertRequest request, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    EzWriteResult update_driver(1:string collection, 2:EzUpdateRequest request, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    ResultsWrapper drop_driver(1:string collection, 2:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    EzWriteResult createIndex_driver(1:string collection, 2:EzCreateIndexRequest request, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    EzGetMoreResponse getMore_driver(1:string collection, 2:EzGetMoreRequest request, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    EzParallelScanResponse parallelScan_driver(1:string collection, 2:EzParallelScanOptions options, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
    EzWriteResult remove_driver(1:string collection, 2:EzRemoveRequest request, 3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);

    // DBTCPConnector methods
    i32 getMaxBsonObjectSize_driver(3:ezbakeBaseTypes.EzSecurityToken security) throws (1:EzMongoDriverException EzMongoDriverException);
}
