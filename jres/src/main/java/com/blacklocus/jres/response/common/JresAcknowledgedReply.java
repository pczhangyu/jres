/**
 * Copyright 2013 BlackLocus
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
package com.blacklocus.jres.response.common;

import com.blacklocus.jres.request.index.JresCreateIndex;
import com.blacklocus.jres.request.mapping.JresPutMapping;
import com.blacklocus.jres.response.JresJsonReply;

/**
 * Possible response for <ul>
 * <li>{@link JresCreateIndex}</li>
 * <li>{@link JresPutMapping}</li>
 * </ul>
 *
 * @author Jason Dunkelberger (dirkraft)
 */
public class JresAcknowledgedReply extends JresJsonReply {

    private Boolean ok;
    private Boolean acknowledged;

    public Boolean getOk() {
        return ok;
    }

    public Boolean getAcknowledged() {
        return acknowledged;
    }
}