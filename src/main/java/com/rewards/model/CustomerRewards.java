package com.rewards.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data @Getter @Setter
public class CustomerRewards {

    private String customerName;
    private List<MonthlyRewards> rewardsByMonth;
    private int totalRewards;
}
