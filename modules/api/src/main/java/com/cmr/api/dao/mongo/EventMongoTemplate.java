package com.cmr.api.dao.mongo;

import com.cmr.api.dao.config.MongoDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.stereotype.Component;

/**
 * @author rajith
 */
@Component
public class EventMongoTemplate extends AbstractMongoTemplate {

    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Override
    protected String getDatabaseName() {
        return mongoDBConfig.getEventDatabaseName();
    }

    @Bean
    public MongoTemplate eventMongoTemplate() throws Exception {
        final MongoTemplate template = new MongoTemplate(
                mongoDbFactory(), mappingMongoConverter());
        template.setWriteResultChecking(WriteResultChecking.EXCEPTION);
        return template;
    }
}
