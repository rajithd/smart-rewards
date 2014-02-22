package com.cmr.rule.service;

import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : rajith
 */
public class HiveTableImporter {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HiveTableImporter.class);

    public void dropAndCreateTable(Connection hiveConnection, String tableName, Set<String> columns) throws SQLException {
        logger.info("Try to drop and create hive table : [{}]", tableName);
        dropHiveTable(hiveConnection, tableName);
        createHiveTable(hiveConnection, tableName, columns);
    }

    private void dropHiveTable(Connection hiveCon, String tableName) throws SQLException {
        Statement dropStmt = hiveCon.createStatement();
        dropStmt.execute("drop table " + tableName);
        dropStmt.close();
        logger.info("Successfully drop table : [{}]",tableName);
    }

    private void createHiveTable(Connection hiveCon, String tableName, Set<String> columns) throws SQLException {
        List<String> list = new ArrayList<String>(columns);
        logger.info("Try to create hive table : [{}]", tableName);
        StringBuilder hiveDDLBuilder = new StringBuilder("create table ");
        hiveDDLBuilder.append(tableName);
        hiveDDLBuilder.append(" (");
        int i = 0;
        for (; i < list.size(); i++) {
            hiveDDLBuilder.append(list.get(i));
            hiveDDLBuilder.append(" ");
            hiveDDLBuilder.append("string");
            if (i < columns.size() - 1) {
                hiveDDLBuilder.append(",");
            }
        }
        hiveDDLBuilder.append(")");

        logger.info("Hive Query: {}", hiveDDLBuilder.toString());

        Statement stmt = hiveCon.createStatement();
        ResultSet res = null;
        try {
            res = stmt.executeQuery(hiveDDLBuilder.toString());
            res.close();
        } finally {
            stmt.close();
        }

    }

}
