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

package org.apache.usergrid.persistence.graph.impl;


import java.util.UUID;

import org.apache.usergrid.persistence.collection.mvcc.entity.ValidationUtils;
import org.apache.usergrid.persistence.graph.Edge;
import org.apache.usergrid.persistence.graph.MarkedEdge;
import org.apache.usergrid.persistence.model.entity.Id;


/**
 * Simple bean to represent our edge
 * @author tnine
 */
public class SimpleMarkedEdge extends  SimpleEdge implements MarkedEdge {

    private final boolean deleted;


    public SimpleMarkedEdge( final Id sourceNode, final String type, final Id targetNode, final UUID version, final boolean deleted) {

        super(sourceNode, type, targetNode, version);
        this.deleted = deleted;
    }



    @Override
    public boolean isDeleted() {
        return deleted;
    }


    /**
     * We purposefully don't implement hashcode or equals.  The only additional field is deleted.  We don't want to compare
     * edge equality based on deleted true/false, since this does not define relevant indexing information for a marked edge
     *
     */


    @Override
    public String toString() {
        return "SimpleMarkedEdge{" +
                "sourceNode=" + sourceNode +
                ", type='" + type + '\'' +
                ", targetNode=" + targetNode +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }
}