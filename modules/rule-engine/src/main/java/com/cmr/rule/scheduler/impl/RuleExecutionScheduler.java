package com.cmr.rule.scheduler.impl;

import com.cmr.beans.campaign.Campaign;
import com.cmr.rule.scheduler.RuleJobScheduler;
import com.cmr.rule.service.RuleEngineService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : rajith
 */
public class RuleExecutionScheduler implements RuleJobScheduler {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RuleExecutionScheduler.class);

    @Autowired
    private RuleEngineService ruleEngineService;

    @Override
    public void execute() throws InterruptedException {
        logger.info("==============================================");
        logger.info("   Rule executor scheduler started");
        logger.info("==============================================");

        List<Campaign> allCampaigns = ruleEngineService.findAllCampaigns();
    }
}
