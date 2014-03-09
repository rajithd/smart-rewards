package com.cmr.rule.scheduler.impl;

import com.cmr.rule.config.RuleRestConfig;
import com.cmr.rule.scheduler.RuleJobScheduler;
import com.cmr.rule.service.RuleEngineService;
import com.cmr.rule.service.TableImporterCallable;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * @author : rajith
 */
public class HiveTableImporterScheduler implements RuleJobScheduler {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HiveTableImporterScheduler.class);

    @Autowired
    private RuleEngineService ruleEngineService;
    @Autowired
    private DataSource hiveDataSource;
    @Autowired
    private RuleRestConfig ruleRestConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    protected ExecutorService executorService;

    @Override
    public void execute() throws InterruptedException {
        logger.info("==============================================");
        logger.info("        Hive Table Import Started");
        logger.info("==============================================");

        Set<String> collectionNames = ruleEngineService.getAllCollectionNames();
        if (collectionNames.isEmpty()) {
            logger.warn("Collection names null. Returning without creating tables in hive");
            return;
        }
        logger.info("Found [{}] number of collection names", collectionNames.size());
        CountDownLatch countDownLatch = new CountDownLatch(collectionNames.size());
        for (String collectionName : collectionNames) {
            TableImporterCallable tableImporterCallable = new TableImporterCallable(hiveDataSource, ruleRestConfig, restTemplate, collectionName, countDownLatch);
            executorService.submit(tableImporterCallable);
        }

        countDownLatch.await();
        logger.info("==============================================");
        logger.info("          Hive table importer Done. ");
        logger.info("==============================================");

    }

}
