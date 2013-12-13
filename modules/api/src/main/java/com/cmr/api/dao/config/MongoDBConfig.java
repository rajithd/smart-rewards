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

    @Value("${smart.rewards.events.database.name}")
    private String eventDatabaseName;

    @Value("${smart.rewards.events.voice.call.collection}")
    private String voiceCallCollectionName;

    public String getMongoHost() {
        return mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public String getEventDatabaseName() {
        return eventDatabaseName;
    }

    public String getVoiceCallCollectionName() {
        return voiceCallCollectionName;
    }
}
