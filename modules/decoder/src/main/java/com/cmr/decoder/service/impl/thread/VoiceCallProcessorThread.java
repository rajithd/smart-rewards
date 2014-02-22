package com.cmr.decoder.service.impl.thread;

import com.cmr.beans.event.EventFactory;
import com.cmr.beans.event.EventTypeEnum;
import com.cmr.beans.event.VoiceCallEvent;
import com.cmr.decoder.config.RestConfig;
import com.cmr.util.Constants;
import com.cmr.util.UrlHandler;
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
        VoiceCallEvent callEvent = (VoiceCallEvent) EventFactory.buildEventWithValues(EventTypeEnum.VOICE_CALL_EVENT, columnValues);
        logger.info("Sending voice call : [{}] to save", callEvent);
        String url = UrlHandler.createUrl(Constants.ESB_SERVICE_VOICE_CALL, restConfig.getApiHostUrl(), restConfig.getEsbService());
        logger.info("Create URL as : [{}]", url);
        String entity = restTemplate.postForObject(url, callEvent, String.class);
        logger.info("Received response : [{}]", entity);
    }

}
