package com.rewards.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Getter @Setter
public class MonthlyRewards {

    private int month;
    private int rewards;
}
