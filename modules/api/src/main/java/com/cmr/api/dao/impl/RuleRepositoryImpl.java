package com.cmr.api.dao.impl;

import com.cmr.api.dao.RuleRepository;
import com.cmr.api.dao.config.MongoDBConfig;
import com.cmr.beans.mongo.ValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author : rajith
 */
@Repository
public class RuleRepositoryImpl implements RuleRepository {

    private final static Logger logger = LoggerFactory.getLogger(EventRepositoryImpl.class);

    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Set<String> findAllCollections() {
        logger.info("Try to find all collections");
        return mongoTemplate.getCollectionNames();
    }

    @Override
    public MapReduceResults<ValueObject> findCollectionKeysByName(String collectionName) {
        String map = "function () { for (var key in this) { emit(key, null); } }";
        String reduce = "function(key, stuff) { return null; }";
        return mongoTemplate.mapReduce(collectionName, map, reduce, ValueObject.class);
    }
}
