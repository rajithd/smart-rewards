package com.cmr.rule.scheduler.impl;

import com.cmr.beans.campaign.Campaign;
import com.cmr.rule.scheduler.RuleJobScheduler;
import com.cmr.rule.service.MailSender;
import com.cmr.rule.service.RuleEngineService;
import com.cmr.rule.service.RuleExecutionAggregator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : rajith
 */
public class RuleExecutionScheduler implements RuleJobScheduler {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RuleExecutionScheduler.class);

    @Autowired
    private RuleEngineService ruleEngineService;
    @Autowired
    private DataSource hiveDataSource;
    @Autowired
    private MailSender mailSender;
    @Autowired
    private HiveTableImporterScheduler hiveTableImporterScheduler;

    @Override
    public void execute() throws InterruptedException, SQLException {
        hiveTableImporterScheduler.execute();
        logger.info("==============================================");
        logger.info("   Rule executor scheduler started");
        logger.info("==============================================");

        List<Campaign> allCampaigns = ruleEngineService.findAllCampaigns();

        Date currentDate = new Date();

        for (Campaign campaign : allCampaigns) {
            if (currentDate.after(campaign.getStartDate()) && currentDate.before(campaign.getEndDate())) {
                logger.info("Found correct campaign to execute : [{}]", campaign.getId());
                RuleExecutionAggregator ruleExecutionAggregator = new RuleExecutionAggregator(campaign,hiveDataSource.getConnection());
                List<String> callerList = ruleExecutionAggregator.executeAggregation();
                mailSender.send("Winner Notification list", callerList.toString());
            }
        }

    }
}
