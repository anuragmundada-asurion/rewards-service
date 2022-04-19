package com.rewards.service.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(PowerMockRunner.class)
public class CustomerRewardsRowMapperTests {

    @InjectMocks
    CustomerRewardsRowMapper mapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMapRow() throws SQLException {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.getInt(ArgumentMatchers.anyString())).thenReturn(100);
        Mockito.when(resultSet.getString(ArgumentMatchers.anyString())).thenReturn("[\n" +
                "      {\n" +
                "        \"month\": 1,\n" +
                "        \"rewards\": 5\n" +
                "      },\n" +
                "      {\n" +
                "        \"month\": 2,\n" +
                "        \"rewards\": 160\n" +
                "      },\n" +
                "      {\n" +
                "        \"month\": 3,\n" +
                "        \"rewards\": 26\n" +
                "      }\n" +
                "    ]");
        mapper.mapRow(resultSet, 1);
    }
}
