package com.cmr.decoder.service.impl.thread;

import com.cmr.beans.event.EventFactory;
import com.cmr.beans.event.EventTypeEnum;
import com.cmr.beans.event.SMSEvent;
import com.cmr.decoder.config.RestConfig;
import com.cmr.decoder.util.UrlHandler;
import com.cmr.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author rajith
 */
public class SMSProcessorThread implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(SMSProcessorThread.class);

    private RestTemplate restTemplate;
    private RestConfig restConfig;
    private String columnSeparator;
    private String record;

    public SMSProcessorThread(String record, String columnSeparator, RestTemplate restTemplate, RestConfig restConfig) {
        this.record = record;
        this.columnSeparator = columnSeparator;
        this.restTemplate = restTemplate;
        this.restConfig = restConfig;
    }

    @Override
    public void run() {
        logger.info("Try to split values from record");
        String[] columnValues = record.split(columnSeparator);
        SMSEvent smsEvent = (SMSEvent) EventFactory.buildEventWithValues(EventTypeEnum.SMS_EVENT, columnValues);
        logger.info("Sending sms events : [{}] to save", smsEvent);
        String url = UrlHandler.createUrl(Constants.ESB_SERVICE_SMS, restConfig);
        logger.info("Create URL as : [{}]", url);
        String entity = restTemplate.postForObject(url, smsEvent, String.class);
        logger.info("Received response : [{}]", entity);
    }
}
