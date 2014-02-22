package com.cmr.rule.service;

import com.cmr.beans.common.Response;
import com.cmr.rule.config.RuleRestConfig;
import com.cmr.util.Constants;
import com.cmr.util.JsonConverter;
import com.cmr.util.UrlHandler;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @author : rajith
 */
public class TableImporterCallable implements Callable {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TableImporterCallable.class);

    private DataSource hiveDataSource;
    private RuleRestConfig ruleRestConfig;
    private RestTemplate restTemplate;
    private String tableName;
    private CountDownLatch countDownLatch;


    public TableImporterCallable(DataSource hiveDataSource, RuleRestConfig ruleRestConfig, RestTemplate restTemplate, String tableName, CountDownLatch countDownLatch) {
        this.hiveDataSource = hiveDataSource;
        this.ruleRestConfig = ruleRestConfig;
        this.restTemplate = restTemplate;
        this.tableName = tableName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Object call() throws Exception {
        logger.info("Table importer call");
        HiveTableImporter hiveTableImporter = new HiveTableImporter();
        Connection hiveConnection = null;

        String url = UrlHandler.createUrl(Constants.ESB_RULE_FIND_COLUMNS_BY_NAME, ruleRestConfig.getApiHostUrl(), ruleRestConfig.getEsbService());
        String finalUrl = url + "/" + tableName;
        logger.info("Create URL to get collection col names : [{}]", finalUrl);
        String jsonResponse = restTemplate.getForObject(finalUrl, String.class);
        Response response = JsonConverter.getResponseObject(Response.class, jsonResponse);

        if (response.getPayLoad().isEmpty()) {
            logger.warn("Response payload is null.So return without creating table");
            return null;
        }

        Set<String> colNames = renameColumnsNames(response.getPayLoad());
        logger.info("Number of cols to create : [{}]", colNames);

        try {
            hiveConnection = hiveDataSource.getConnection();
            hiveTableImporter.dropAndCreateTable(hiveConnection, tableName, colNames);
        } finally {
            if (hiveConnection != null) {
                try {
                    hiveConnection.close();
                } catch (SQLException e) {
                    logger.error("Error closing hive connection", e);
                }
            }
            this.countDownLatch.countDown();
        }

        return null;
    }

    private Set<String> renameColumnsNames(Set<String> colNames) {
        logger.info("Remove _class col names and rename _id as id");
        colNames.remove(Constants.COLLECTION_CLASS_COL_NAME);
        colNames.remove(Constants.COLLECTION_CLASS_ID_NAME);
        colNames.add(Constants.COLLECTION_CLASS_ID_NEW_NAME);
        return colNames;
    }
}
