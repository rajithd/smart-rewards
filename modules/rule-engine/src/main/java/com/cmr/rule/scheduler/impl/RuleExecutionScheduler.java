package com.cmr.rule.scheduler.impl;

import com.cmr.rule.scheduler.RuleJobScheduler;
import org.slf4j.LoggerFactory;

/**
 * @author : rajith
 */
public class RuleExecutionScheduler implements RuleJobScheduler {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RuleExecutionScheduler.class);

    @Override
    public void execute() throws InterruptedException {
        logger.info("==============================================");
        logger.info("   Rule executor scheduler started");
        logger.info("==============================================");

    }
}
