package com.cmr.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthConfig {

    @Value("${smart.rewards.mongo.host}")
    private String mongoHost;

    @Value("${smart.rewards.mongo.port}")
    private int mongoPort;

    @Value("${smart.rewards.user-mgt.database.name}")
    private String userManagementDatabaseName;

    @Value("${smart.rewards.user-mgt.user.collection.name}")
    private String userCollectionName;

    public String getMongoHost() {
        return mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public String getUserManagementDatabaseName() {
        return userManagementDatabaseName;
    }

    public String getUserCollectionName() {
        return userCollectionName;
    }
}
