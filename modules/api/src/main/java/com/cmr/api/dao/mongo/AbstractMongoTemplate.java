package com.cmr.api.dao.mongo;

import com.cmr.api.dao.config.MongoDBConfig;
import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author rajith
 */
public abstract class AbstractMongoTemplate extends AbstractMongoConfiguration {

    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Override
    protected abstract String getDatabaseName();

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new Mongo(mongoDBConfig.getMongoHost(), mongoDBConfig.getMongoPort());
    }

    @Bean
    public SimpleMongoDbFactory mongoDbFactory() throws Exception {
        final UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongo(), getDatabaseName(),
                userCredentials);
    }

}
