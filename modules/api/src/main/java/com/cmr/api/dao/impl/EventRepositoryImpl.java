package com.cmr.api.dao.impl;

import com.cmr.api.dao.EventRepository;
import com.cmr.api.dao.config.MongoDBConfig;
import com.cmr.beans.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rajith
 */
@Repository
public class EventRepositoryImpl implements EventRepository {

    private final static Logger logger = LoggerFactory.getLogger(EventRepositoryImpl.class);

    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(AbstractEvent abstractEvent) {
        if(abstractEvent instanceof VoiceCallEvent){
            logger.info("Try to save voice call event type");
            mongoTemplate.insert(abstractEvent, mongoDBConfig.getVoiceCallCollectionName());
        } else if(abstractEvent instanceof SMSEvent){
            logger.info("Try to save sms event type");
            mongoTemplate.insert(abstractEvent, mongoDBConfig.getSmsEventCollectionName());
        } else if(abstractEvent instanceof ActivationEvent){
            logger.info("Try to save activation event type");
            mongoTemplate.insert(abstractEvent, mongoDBConfig.getActivationCollectionName());
        } else if(abstractEvent instanceof RegistrationEvent){
            logger.info("Try to save registration event type");
            mongoTemplate.insert(abstractEvent, mongoDBConfig.getRegistrationCollectionName());
        }

    }

    @Override
    public List<AbstractEvent> findEventsByEventType(EventTypeEnum eventTypeEnum, String collectionName) {
        return (List<AbstractEvent>) mongoTemplate.findAll(EventFactory.buildEvent(eventTypeEnum).getClass(), collectionName);
    }
}
