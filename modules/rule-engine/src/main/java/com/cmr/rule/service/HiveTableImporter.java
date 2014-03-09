package com.cmr.rule.service;

import com.cmr.util.Constants;
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

    public void importDataIntoTable(Connection hiveConnection, String tableName, Set<String> columns) throws SQLException {
        logger.info("Try to drop and create hive table : [{}]", tableName);
        if(isTableExists(hiveConnection, tableName)){
            logger.info("Table [{}] already exists in hive. returning", tableName);
            return;
        }
        createAndImportDataToHiveTable(hiveConnection, tableName, columns);
    }

    private boolean isTableExists(Connection hiveCon, String tableName) throws SQLException {
        List<String> allTablesInHive = findAllTablesInHive(hiveCon);
        if (allTablesInHive.contains(tableName)) {
            return true;
        }
        return false;
    }

    private List<String> findAllTablesInHive(Connection hiveCon) throws SQLException {
        List<String> tables = new ArrayList<String>();
        Statement statement = hiveCon.createStatement();
        ResultSet resultSet = statement.executeQuery("show tables");
        while (resultSet.next()) {
            tables.add(resultSet.getString("tab_name"));
        }
        statement.close();
        return tables;
    }

    private void createAndImportDataToHiveTable(Connection hiveCon, String tableName, Set<String> columns) throws SQLException {
        String mongoUri = "mongodb://localhost:27017/rewards." + tableName;
        List<String> list = new ArrayList<String>(columns);
        String colMappingJson = mapColumnsToHive(list);
        logger.info("Hive columns mapping : [{}]", colMappingJson);
        logger.info("Try to create and import data to hive table : [{}]", tableName);
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
        hiveDDLBuilder.append(" STORED BY \"com.mongodb.hadoop.hive.MongoStorageHandler\" ");
        hiveDDLBuilder.append(" WITH SERDEPROPERTIES('mongo.columns.mapping'=' " + colMappingJson + " ')");
        hiveDDLBuilder.append(" TBLPROPERTIES ( \"mongo.uri\" =  ");
        hiveDDLBuilder.append("'" + mongoUri + "')");

        logger.info("Hive Query: [{}]", hiveDDLBuilder.toString());

        Statement stmt = hiveCon.createStatement();
        ResultSet res = null;
        try {
            res = stmt.executeQuery(hiveDDLBuilder.toString());
            res.close();
        } finally {
            stmt.close();
        }

    }

    private String mapColumnsToHive(List<String> columns) {
        StringBuilder colMapperString = new StringBuilder();
        colMapperString.append("{");
        colMapperString.append("\"" + "id" + "\"" + ":" + "\"" + "_id" + "\"" + ",");
        int i = 0;
        for (; i < columns.size(); i++) {
            if (Constants.COLLECTION_CLASS_ID_NEW_NAME.equals(columns.get(i)) || Constants.COLLECTION_CLASS_COL_NAME.equals(columns.get(i))) {
                continue;
            }
            colMapperString.append("\"" + columns.get(i) + "\"" + ":" + "\"" + columns.get(i) + "\"");
            if (i < columns.size() - 1) {
                colMapperString.append(",");
            }
        }
        colMapperString.append("}");
        return colMapperString.toString();
    }

}
