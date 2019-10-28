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

package org.apache.shardingsphere.example.core.jdbc.service;


import org.apache.shardingsphere.example.core.api.service.ExampleService;
import org.apache.shardingsphere.example.core.jdbc.repository.ColumnsRepository;

import javax.sql.DataSource;
import java.sql.SQLException;


public final class ColumnsService implements ExampleService {

    private ColumnsRepository columnsRepository;

    public ColumnsService(final DataSource dataSource) {
        this.columnsRepository = new ColumnsRepository(dataSource);
    }


    @Override
    public void initEnvironment() throws SQLException {

    }
    
    @Override
    public void cleanEnvironment() throws SQLException {
    }
    
    @Override
    public void processSuccess() throws SQLException {
        System.out.println("-------------- Process Success Begin ---------------");

        System.out.println("-------------- Process Success Finish --------------");
    }
    
    @Override
    public void processFailure() throws SQLException {
        System.out.println("-------------- Process Failure Begin ---------------");

        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }
    
    @Override
    public void printData() throws SQLException {
        System.out.println("---------------------------- Print Order Data -----------------------");

    }
}
