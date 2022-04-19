package com.rewards.controller;

import com.rewards.model.CustomerRewards;
import com.rewards.service.RewardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/rewards")
public class RewardsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RewardsController.class);

    @Autowired
    private RewardsService rewardsService;

    @Operation(summary = "Get customer rewards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Customer Rewards", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<CustomerRewards>> getListOfCustomerRewards() {
        LOGGER.info("Start calculating rewards: {}", System.nanoTime());

        List<CustomerRewards> customerRewards = rewardsService.getRewards();

        LOGGER.info("End calculating rewards: {}", System.nanoTime());
        return new ResponseEntity<>(customerRewards, HttpStatus.OK);
    }
}
