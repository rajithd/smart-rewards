package com.cmr.api.dao.impl;

import com.cmr.api.dao.UserAccountRepository;
import com.cmr.api.dao.config.MongoDBConfig;
import com.cmr.beans.user.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : rajith
 */
@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(UserAccount userAccount) {
        mongoTemplate.save(userAccount, mongoDBConfig.getUserCollectionName());
    }
}
