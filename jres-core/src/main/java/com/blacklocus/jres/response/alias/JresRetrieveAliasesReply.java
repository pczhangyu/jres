/**
 * Copyright 2015 BlackLocus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blacklocus.jres.response.alias;

import com.blacklocus.jres.request.alias.JresRetrieveAliases;
import com.blacklocus.jres.response.JresJsonReply;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * Response for {@link JresRetrieveAliases}.
 */
public class JresRetrieveAliasesReply extends JresJsonReply {

    public List<String> getIndexes() {
        return Lists.newArrayList(node().fieldNames());
    }

    public List<String> getAliases(String index) {
        JsonNode indexAliases = node().get(index);
        return indexAliases == null ? Collections.<String>emptyList() :
                Lists.newArrayList(indexAliases.get("aliases").fieldNames());
    }
}
