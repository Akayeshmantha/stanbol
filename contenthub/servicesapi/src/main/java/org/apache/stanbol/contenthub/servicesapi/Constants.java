/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.stanbol.contenthub.servicesapi;

import org.apache.stanbol.contenthub.servicesapi.enhancements.vocabulary.EnhancementGraphVocabulary;

/**
 * @author anil.sinaci
 *
 */
public class Constants {
    
    public static final String DEFAULT_ENCODING = "UTF-8";
    
    public static final String ENHANCER_ENTITIY_CACHE_GRAPH_URI = "enhancerEntityCache";
    public static final String[] RESERVED_GRAPH_URIs = {ENHANCER_ENTITIY_CACHE_GRAPH_URI,
                                                        EnhancementGraphVocabulary.ENHANCEMENTS_GRAPH_URI};

    public static boolean isGraphReserved(String graphURI) {
        for (String uri : RESERVED_GRAPH_URIs) {
            if (uri.equals(graphURI)) return true;
        }
        return false;
    }
}
