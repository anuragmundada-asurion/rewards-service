package com.rewards.service.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rewards.model.CustomerRewards;
import com.rewards.model.MonthlyRewards;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRewardsRowMapper implements RowMapper<CustomerRewards> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRewardsRowMapper.class);

    @Override
    public CustomerRewards mapRow(ResultSet resultSet, int i) throws SQLException {
        CustomerRewards customerRewards = new CustomerRewards();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            customerRewards.setCustomerName(resultSet.getString("customer_name"));
            customerRewards.setRewardsByMonth(objectMapper.readValue(resultSet.getString("monthly_rewards"), new TypeReference<List<MonthlyRewards>>() {}));
            customerRewards.setTotalRewards(resultSet.getInt("total_rewards"));
        } catch (JsonProcessingException e) {
            LOGGER.error("Exception processing monthly rewards: {}", e);
        }

        return customerRewards;
    }

}
