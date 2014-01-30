/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
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

package org.apache.usergrid.persistence.graph.test.util;


import java.util.UUID;

import org.apache.usergrid.persistence.graph.Edge;
import org.apache.usergrid.persistence.graph.SearchByEdgeType;
import org.apache.usergrid.persistence.graph.SearchByIdType;
import org.apache.usergrid.persistence.graph.SearchEdgeType;
import org.apache.usergrid.persistence.graph.impl.SimpleEdge;
import org.apache.usergrid.persistence.graph.impl.SimpleSearchByEdgeType;
import org.apache.usergrid.persistence.graph.impl.SimpleSearchByIdType;
import org.apache.usergrid.persistence.graph.impl.SimpleSearchEdgeType;
import org.apache.usergrid.persistence.graph.impl.SimpleSearchIdType;
import org.apache.usergrid.persistence.model.entity.Id;
import org.apache.usergrid.persistence.model.util.UUIDGenerator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 *  Simple class for edge testing generation
 *
 */
public class EdgeTestUtils {


    /**
     * Create an edge for testing
     * @param sourceType The source type to use in the id
     * @param edgeType The edge type to use
     * @param targetType The target type to use
     * @return an Edge for testing
     */
    public static Edge createEdge( final String sourceType, final String edgeType, final String targetType ) {
        return createEdge( createId( sourceType ), edgeType, createId( targetType ) );
    }


    /**
     * Create an edge with the specified params
     * @param sourceId
     * @param edgeType
     * @param targetId
     * @return
     */
    public static Edge createEdge(final Id sourceId, final String edgeType, final Id targetId){
       return new SimpleEdge( sourceId, edgeType, targetId, UUIDGenerator.newTimeUUID() );
    }


    /**
     * Create the id
     * @param type
     * @return
     */
    public static Id createId(String type){
        Id sourceId = mock( Id.class );
        when( sourceId.getType() ).thenReturn( type );
        when( sourceId.getUuid() ).thenReturn( UUIDGenerator.newTimeUUID() );

        return sourceId;
    }


    /**
     *
     * @param sourceId
     * @param type
     * @param maxVersion
     * @param last
     * @return
     */
    public static SearchByEdgeType createSearchByEdge( final Id sourceId, final String type, final UUID maxVersion,
                                                 final Edge last ) {
        return new SimpleSearchByEdgeType( sourceId, type, maxVersion, last );
    }


    /**
     *
     * @param sourceId
     * @param type
     * @param maxVersion
     * @param idType
     * @param last
     * @return
     */
    public static SearchByIdType createSearchByEdgeAndId( final Id sourceId, final String type, final UUID maxVersion,
                                                    final String idType, final Edge last ) {
        return new SimpleSearchByIdType( sourceId, type, maxVersion, idType, last );
    }


    /**
     *
     * @param sourceId
     * @param last
     * @return
     */
    public static SearchEdgeType createSearchEdge( final Id sourceId, final String last ) {
        return new SimpleSearchEdgeType( sourceId, last );
    }


    /**
     * Create the search by Id type
     *
     * @param sourceId
     * @param type
     * @param last
     * @return
     */
    public static SimpleSearchIdType createSearchIdType( final Id sourceId, final String type, final String last ) {
        return new SimpleSearchIdType( sourceId, type, last );
    }

}

