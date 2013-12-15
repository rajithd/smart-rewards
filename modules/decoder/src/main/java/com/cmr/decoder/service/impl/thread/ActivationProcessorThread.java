package com.cmr.decoder.service.impl.thread;

import com.cmr.beans.event.ActivationEvent;
import com.cmr.beans.event.EventFactory;
import com.cmr.beans.event.EventTypeEnum;
import com.cmr.decoder.config.RestConfig;
import com.cmr.decoder.util.UrlHandler;
import com.cmr.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author rajith
 */
public class ActivationProcessorThread implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(ActivationProcessorThread.class);

    private RestTemplate restTemplate;
    private RestConfig restConfig;
    private String columnSeparator;
    private String record;

    public ActivationProcessorThread(String record, String columnSeparator, RestTemplate restTemplate, RestConfig restConfig) {
        this.record = record;
        this.columnSeparator = columnSeparator;
        this.restTemplate = restTemplate;
        this.restConfig = restConfig;
    }

    @Override
    public void run() {
        logger.info("Try to split values from record");
        String[] columnValues = record.split(columnSeparator);
        ActivationEvent activationEvent = (ActivationEvent) EventFactory.buildEventWithValues(EventTypeEnum.ACTIVATION_EVENT, columnValues);
        logger.info("Sending activation events : [{}] to save", activationEvent);
        String url = UrlHandler.createUrl(Constants.ESB_SERVICE_ACTIVATION, restConfig);
        logger.info("Create URL as : [{}]", url);
        String entity = restTemplate.postForObject(url, activationEvent, String.class);
        logger.info("Received response : [{}]", entity);
    }
}
