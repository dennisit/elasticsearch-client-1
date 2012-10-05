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

package org.elasticsearch.action.mlt;

import org.elasticsearch.action.Action;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.SearchClient;

/**
 */
public class MoreLikeThisAction extends Action<MoreLikeThisRequest, SearchResponse, MoreLikeThisRequestBuilder, SearchClient> {

    public static final MoreLikeThisAction INSTANCE = new MoreLikeThisAction();
    public static final String NAME = "mlt";

    private MoreLikeThisAction() {
        super(NAME);
    }

    @Override
    public SearchResponse newResponse() {
        return new SearchResponse();
    }

    @Override
    public MoreLikeThisRequestBuilder newRequestBuilder(SearchClient client) {
        return new MoreLikeThisRequestBuilder(client);
    }
}