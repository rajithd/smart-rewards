package com.cmr.api.service.impl;

import com.cmr.api.dao.EventRepository;
import com.cmr.api.service.ReplicateService;
import com.cmr.beans.event.ActivationEvent;
import com.cmr.beans.event.RegistrationEvent;
import com.cmr.beans.event.SMSEvent;
import com.cmr.beans.event.VoiceCallEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rajith
 */
@Service
public class ReplicateServiceImpl implements ReplicateService {

    private final static Logger logger = LoggerFactory.getLogger(ReplicateServiceImpl.class);

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void replicateVoiceCallEvents(VoiceCallEvent voiceCallEvent) {
        logger.info("Saving voice call events to database");
        eventRepository.save(voiceCallEvent);
        logger.info("Successfully Saved voice call events to database");
    }

    @Override
    public void replicateSMSEvents(SMSEvent smsEvent) {
        logger.info("Saving sms events to database");
        eventRepository.save(smsEvent);
        logger.info("Successfully Saved sms events to database");
    }

    @Override
    public void replicateRegistrationEvent(RegistrationEvent registrationEvent) {
        logger.info("Saving registration events to database");
        eventRepository.save(registrationEvent);
        logger.info("Successfully Saved registration events to database");
    }

    @Override
    public void replicateActivationEvent(ActivationEvent activationEvent) {
        logger.info("Saving activation events to database");
        eventRepository.save(activationEvent);
        logger.info("Successfully Saved activation events to database");
    }
}
