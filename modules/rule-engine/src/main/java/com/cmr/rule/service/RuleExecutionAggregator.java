package com.cmr.rule.service;

import com.cmr.beans.campaign.Campaign;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rajith
 */
public class RuleExecutionAggregator {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RuleExecutionAggregator.class);

    private Campaign campaign;
    private Connection hiveConnection;

    public RuleExecutionAggregator(Campaign campaign, Connection hiveConnection) {
        this.campaign = campaign;
        this.hiveConnection = hiveConnection;
    }

    public List<String> executeAggregation() {
        logger.info("Preparing to aggregate sql summery");
        RuleSQLSummery ruleSQLSummery = new RuleSQLSummery();
        String sql = ruleSQLSummery.ruleExecuteSql(campaign);
        logger.info("Crete Hive sql as : [{}]", sql);

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = hiveConnection.createStatement();
            resultSet = statement.executeQuery(sql);
            return findCallerList(resultSet);

        } catch (SQLException e) {
            logger.error("Error occur while executing hive ", e);
        } finally {
            assert statement != null;
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("Error occur while closing hive connection ", e);
            }
        }
        return Collections.emptyList();
    }

    private List<String> findCallerList(ResultSet resultSet) throws SQLException {
        List<String> callerList=new ArrayList<String>();
        while (resultSet.next()){
            callerList.add(resultSet.getString("caller"));
        }
        return callerList;
    }

}
