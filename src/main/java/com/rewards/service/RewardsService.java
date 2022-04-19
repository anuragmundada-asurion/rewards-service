package com.rewards.service;

import com.rewards.model.CustomerRewards;
import com.rewards.service.mapper.CustomerRewardsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardsService {

    private static final String GET_CUSTOMER_REWARDS = "SELECT customer_name, JSON_ARRAYAGG(JSON_OBJECT('month': month, 'rewards': points)) FORMAT JSON AS monthly_rewards, SUM(points) AS total_rewards FROM\n" +
            "(SELECT customer_name, EXTRACT(MONTH FROM purchase_date) AS month, SUM(CASE WHEN FLOOR(purchase_amount) <= 50 THEN 0 WHEN FLOOR(purchase_amount) > 100 THEN (50 + 2*(FLOOR(purchase_amount)-100)) ELSE FLOOR(purchase_amount) - 50 END) AS points FROM purchase_details GROUP BY customer_name, month) X GROUP BY customer_name;";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<CustomerRewards> getRewards() {
        return namedParameterJdbcTemplate.query(GET_CUSTOMER_REWARDS, new CustomerRewardsRowMapper());
    }
}
