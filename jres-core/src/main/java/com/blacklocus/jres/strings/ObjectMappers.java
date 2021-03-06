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
package com.blacklocus.jres.strings;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.InputStream;

public class ObjectMappers {

    public static final ObjectMapper NORMAL = newConfiguredObjectMapper();

    public static final ObjectMapper PRETTY = newConfiguredObjectMapper();
    static {
        PRETTY.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    static ObjectMapper newConfiguredObjectMapper() {
        return new ObjectMapper()
                // ElasticSearch is usually more okay with absence of properties rather than presence with null values.
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                // Allow empty JSON objects where they might occur.
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                // Not all properties need to be mapped back into POJOs.
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Convenience around {@link ObjectMapper#writeValueAsString(Object)} with {@link ObjectMappers#NORMAL} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static String toJson(Object o) {
        try {
            return NORMAL.writeValueAsString(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convenience around {@link ObjectMapper#writeValueAsString(Object)} with {@link ObjectMappers#PRETTY} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static String toJsonPretty(Object o) {
        try {
            return PRETTY.writeValueAsString(o);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convenience around {@link ObjectMapper#readValue(String, Class)} with {@link ObjectMappers#NORMAL} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static <T> T fromJson(String json, Class<T> klass) {
        try {
            return NORMAL.readValue(json, klass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convenience around {@link ObjectMapper#readValue(String, TypeReference)} with {@link ObjectMappers#NORMAL} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        try {
            return NORMAL.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convenience around {@link ObjectMapper#readValue(InputStream, Class)} with {@link ObjectMappers#NORMAL} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static <T> T fromJson(InputStream json, Class<T> klass) {
        try {
            return NORMAL.readValue(json, klass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convenience around {@link ObjectMapper#readValue(InputStream, TypeReference)} with {@link ObjectMappers#NORMAL} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static <T> T fromJson(InputStream json, TypeReference<T> typeReference) {
        try {
            return NORMAL.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convenience around {@link ObjectMapper#readValue(JsonParser, Class)} with {@link ObjectMappers#NORMAL} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static <T> T fromJson(JsonNode json, Class<T> klass) {
        try {
            return NORMAL.readValue(json.traverse(NORMAL), klass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convenience around {@link ObjectMapper#readValue(JsonParser, TypeReference)} with {@link ObjectMappers#NORMAL} wrapping
     * checked exceptions in {@link RuntimeException}
     */
    public static <T> T fromJson(JsonNode json, TypeReference<T> typeReference) {
        try {
            return NORMAL.readValue(json.traverse(NORMAL), typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
