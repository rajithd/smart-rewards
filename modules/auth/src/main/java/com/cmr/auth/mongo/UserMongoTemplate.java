package com.cmr.auth.mongo;

import com.cmr.auth.config.AuthConfig;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.stereotype.Component;

@Component
public class UserMongoTemplate extends AbstractMongoConfiguration {

    @Autowired
    private AuthConfig authConfig;

    @Override
    protected String getDatabaseName() {
        return authConfig.getUserManagementDatabaseName();
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo(authConfig.getMongoHost(), authConfig.getMongoPort());
    }

    @Bean
    public SimpleMongoDbFactory mongoDbFactory() throws Exception {
        final UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongo(), getDatabaseName(),
                userCredentials);
    }

    @Bean
    public MongoTemplate userMongoTemplate() throws Exception {
        final MongoTemplate template = new MongoTemplate(
                mongoDbFactory(), mappingMongoConverter());
        template.setWriteResultChecking(WriteResultChecking.EXCEPTION);
        return template;
    }
}
