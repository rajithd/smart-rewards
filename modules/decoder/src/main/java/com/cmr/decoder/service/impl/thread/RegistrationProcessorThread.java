package com.cmr.decoder.service.impl.thread;

import com.cmr.beans.event.EventFactory;
import com.cmr.beans.event.EventTypeEnum;
import com.cmr.beans.event.RegistrationEvent;
import com.cmr.decoder.config.RestConfig;
import com.cmr.util.Constants;
import com.cmr.util.UrlHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author rajith
 */
public class RegistrationProcessorThread implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(RegistrationProcessorThread.class);

    private RestTemplate restTemplate;
    private RestConfig restConfig;
    private String columnSeparator;
    private String record;

    public RegistrationProcessorThread(String record, String columnSeparator, RestTemplate restTemplate, RestConfig restConfig) {
        this.record = record;
        this.columnSeparator = columnSeparator;
        this.restTemplate = restTemplate;
        this.restConfig = restConfig;
    }

    @Override
    public void run() {
        logger.info("Try to split values from record");
        String[] columnValues = record.split(columnSeparator);
        RegistrationEvent registrationEvent = (RegistrationEvent) EventFactory.buildEventWithValues(EventTypeEnum.REGISTRATION_EVENT, columnValues);
        logger.info("Sending registration events : [{}] to save", registrationEvent);
        String url = UrlHandler.createUrl(Constants.ESB_SERVICE_REGISTRATION, restConfig.getApiHostUrl(), restConfig.getEsbService());
        logger.info("Create URL as : [{}]", url);
        String entity = restTemplate.postForObject(url, registrationEvent, String.class);
        logger.info("Received response : [{}]", entity);
    }
}
