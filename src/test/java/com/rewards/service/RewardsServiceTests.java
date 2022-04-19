package com.rewards.service;

import com.rewards.model.CustomerRewards;
import com.rewards.model.MonthlyRewards;
import com.rewards.service.mapper.CustomerRewardsRowMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class RewardsServiceTests {

    private List<CustomerRewards> customerRewardsList = new ArrayList<>();
    private List<MonthlyRewards> monthlyRewardsList = new ArrayList<>();

    @InjectMocks
    RewardsService rewardsService;

    @Mock
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MonthlyRewards monthlyRewards = new MonthlyRewards();
        monthlyRewards.setMonth(1);
        monthlyRewards.setRewards(100);
        monthlyRewardsList.add(monthlyRewards);
        CustomerRewards customerRewards = new CustomerRewards();
        customerRewards.setCustomerName("Anurag");
        customerRewards.setTotalRewards(100);
        customerRewards.setRewardsByMonth(monthlyRewardsList);
        customerRewardsList.add(customerRewards);
    }

    @Test
    public void testGetRewards() {
        Mockito.when(namedParameterJdbcTemplate.query(ArgumentMatchers.anyString(), ArgumentMatchers.any(CustomerRewardsRowMapper.class))).thenReturn(customerRewardsList);
        Assert.assertTrue(customerRewardsList.equals(rewardsService.getRewards()));
    }
}
