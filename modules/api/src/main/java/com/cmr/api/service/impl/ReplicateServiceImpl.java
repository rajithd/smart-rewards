package com.cmr.api.service.impl;

import com.cmr.api.dao.EventRepository;
import com.cmr.api.service.ReplicateService;
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
}
