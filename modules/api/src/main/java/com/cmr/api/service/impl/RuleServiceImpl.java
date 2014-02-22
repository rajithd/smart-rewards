package com.cmr.api.service.impl;

import com.cmr.api.dao.RuleRepository;
import com.cmr.api.service.RuleService;
import com.cmr.beans.mongo.ValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : rajith
 */
@Service
public class RuleServiceImpl implements RuleService {

    private final static Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);

    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public Set<String> getAllCollectionName() {
        logger.info("Try to find all collection names");
        Set<String> collections = ruleRepository.findAllCollections();
        logger.info("Found [{}] number of collections", collections.size());
        return collections;
    }

    @Override
    public Set<String> getCollectionColumnsByName(String collectionName) {
        logger.info("Find collection keys by name : [{}]", collectionName);
        MapReduceResults<ValueObject> valueObjects = ruleRepository.findCollectionKeysByName(collectionName);
        Iterator<ValueObject> iterator = valueObjects.iterator();

        Set<String> keySet = new HashSet<String>();
        while (iterator.hasNext()) {
            keySet.add(iterator.next().getId());
        }

        logger.info("Found [{}] number of keys for : [{}]", keySet.size(), collectionName);
        return keySet;
    }
}
