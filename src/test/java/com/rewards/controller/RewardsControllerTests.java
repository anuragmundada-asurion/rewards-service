package com.rewards.controller;

import com.rewards.model.CustomerRewards;
import com.rewards.model.MonthlyRewards;
import com.rewards.service.RewardsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
public class RewardsControllerTests {

    private List<CustomerRewards> customerRewardsList = new ArrayList<>();
    private List<MonthlyRewards> monthlyRewardsList = new ArrayList<>();

    @InjectMocks
    RewardsController rewardsController;

    @Mock
    private RewardsService rewardsService;

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
    public void testGetCustomerRewards() {
        Mockito.when(rewardsService.getRewards()).thenReturn(customerRewardsList);
        ResponseEntity<List<CustomerRewards>> response = rewardsController.getListOfCustomerRewards();
        Assert.assertEquals(response.getBody().get(0).getTotalRewards(), 100);
    }
}
