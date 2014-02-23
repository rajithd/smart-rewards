package com.cmr.api.service.impl;

import com.cmr.api.dao.EventRepository;
import com.cmr.api.dao.RuleRepository;
import com.cmr.api.dao.config.MongoDBConfig;
import com.cmr.api.service.RuleService;
import com.cmr.beans.event.AbstractEvent;
import com.cmr.beans.event.EventTypeEnum;
import com.cmr.beans.mongo.ValueObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author : rajith
 */
@Service
public class RuleServiceImpl implements RuleService {

    private final static Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);

    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MongoDBConfig mongoDBConfig;

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

    @Override
    public List<AbstractEvent> findEventsByEventType(String eventType) {
        logger.info("Find events by event : [{}]", eventType);
        if(eventType.equals(mongoDBConfig.getSmsEventCollectionName())){
            return eventRepository.findEventsByEventType(EventTypeEnum.SMS_EVENT, eventType);
        }
        if (eventType.equals(mongoDBConfig.getActivationCollectionName())){
            return eventRepository.findEventsByEventType(EventTypeEnum.ACTIVATION_EVENT, eventType);
        }
        if (eventType.equals(mongoDBConfig.getVoiceCallCollectionName())){
            return eventRepository.findEventsByEventType(EventTypeEnum.VOICE_CALL_EVENT, eventType);
        }
        if (eventType.equals(mongoDBConfig.getRegistrationCollectionName())){
            return eventRepository.findEventsByEventType(EventTypeEnum.REGISTRATION_EVENT, eventType);
        }
        return null;

    }
}
