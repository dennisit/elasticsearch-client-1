/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.http.action.admin.indices.status;

import org.elasticsearch.action.admin.indices.status.IndicesStatusRequest;
import org.elasticsearch.action.admin.indices.status.IndicesStatusResponse;
import org.elasticsearch.action.support.HttpAction;
import org.elasticsearch.action.support.HttpRequest;
import org.elasticsearch.action.support.HttpResponse;
import org.elasticsearch.common.xcontent.XContentHelper;

import java.io.IOException;
import java.util.Map;

public class HttpIndicesStatusAction extends HttpAction<IndicesStatusRequest, IndicesStatusResponse> {

    public static final String NAME = "indices_status";
    private static final String ENDPOINT = "_status";

    @Override
    protected HttpRequest toRequest(IndicesStatusRequest request) {
        HttpRequest httpRequest = new HttpRequest(GET, ENDPOINT)
                .index(request.indices());
        if (request.ignoreIndices() != null) {
            httpRequest.param("ignore_indices", request.ignoreIndices().name().toLowerCase());
        }
        return httpRequest;
    }

    @Override
    protected IndicesStatusResponse toResponse(HttpResponse response) throws IOException {
        Map<String, Object> map = XContentHelper.convertToMap(response.getBody(), false).v2();
        logger.info("response = {}", map);
        return null;
    }
}
