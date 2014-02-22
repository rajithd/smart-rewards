package com.cmr.auth.dao.impl;


import com.cmr.auth.config.AuthConfig;
import com.cmr.auth.dao.UserRepository;
import com.cmr.beans.user.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private AuthConfig authConfig;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserAccount findUserAccountByUsername(String username) {
        return mongoTemplate.findOne(new Query(Criteria.where("username").is(username)),
                UserAccount.class, authConfig.getUserCollectionName());
    }
}
