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

package org.apache.shardingsphere.example.core.jdbc.repository;

import org.apache.shardingsphere.example.core.api.repository.CommonRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public final class ColumnsRepository implements CommonRepository {

    private final DataSource dataSource;

    public ColumnsRepository(final DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void createTableIfNotExists() throws SQLException {

    }

    @Override
    public void dropTable() throws SQLException {

    }

    @Override
    public void truncateTable() throws SQLException {

    }

    @Override
    public Object insert(Object entity) throws SQLException {
        return null;
    }

    @Override
    public void delete(Object primaryKey) throws SQLException {

    }

    @Override
    public List selectAll() throws SQLException {
        String sql = "select COLUMNS_V2.* from COLUMNS_V2 left join SDS ON SDS.CD_ID = COLUMNS_V2.CD_ID left join TBLS ON TBLS.TBL_ID = SDS.SD_ID";
        List result = new LinkedList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String COMMENT = String.valueOf(resultSet.findColumn("COMMENT"));
                System.out.println(COMMENT);
            }
        }
        return result;
    }
}
