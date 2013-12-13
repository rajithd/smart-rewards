package com.cmr.decoder.service.impl;

import com.cmr.beans.event.AbstractEvent;
import com.cmr.beans.event.EventFactory;
import com.cmr.beans.event.EventTypeEnum;
import com.cmr.beans.event.VoiceCallEvent;
import com.cmr.decoder.config.RestConfig;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author rajith
 */
public class VoiceCallProcessorThread implements Runnable {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(VoiceCallProcessorThread.class);

    private RestTemplate restTemplate;
    private RestConfig restConfig;
    private String columnSeparator;
    private String record;

    public VoiceCallProcessorThread(String record, String columnSeparator, RestTemplate restTemplate, RestConfig restConfig) {
        this.record = record;
        this.columnSeparator = columnSeparator;
        this.restTemplate = restTemplate;
        this.restConfig = restConfig;
    }

    @Override
    public void run() {
        logger.info("Try to split values from record");
        String[] columnValues = record.split(columnSeparator);
        VoiceCallEvent callEvent = createVoiceCallEvent(columnValues);
        logger.info("Sending voice call : [{}] to save", callEvent);
        String url = createUrl("replicatevoicecall");
        logger.info("Create URL as : [{}]", url);
        String entity = restTemplate.postForObject(url, callEvent, String.class);
        logger.info("Received response : [{}]", entity);
    }

    private VoiceCallEvent createVoiceCallEvent(String[] columnValues) {
        AbstractEvent event = EventFactory.buildEvent(EventTypeEnum.VOICE_CALL_EVENT);
        VoiceCallEvent voiceCallEvent = (VoiceCallEvent) event;
        voiceCallEvent.setId(columnValues[0]);
        voiceCallEvent.setCalleeId(columnValues[1]);
        voiceCallEvent.setCalleeId(columnValues[2]);
        voiceCallEvent.setEventResults(columnValues[5]);
        return voiceCallEvent;
    }

    public String createUrl(String proxyName) {
        return restConfig.getApiHostUrl() + restConfig.getEsbService() + proxyName;
    }
}
