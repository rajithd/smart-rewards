package com.cmr.api.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author rajith
 */
@Configuration
public class MongoDBConfig {

    @Value("${smart.rewards.mongo.host}")
    private String mongoHost;

    @Value("${smart.rewards.mongo.port}")
    private int mongoPort;

}
