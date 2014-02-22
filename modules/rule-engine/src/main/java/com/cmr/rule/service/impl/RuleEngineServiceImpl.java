package com.cmr.rule.service.impl;

import com.cmr.beans.common.Response;
import com.cmr.rule.config.RuleRestConfig;
import com.cmr.rule.service.RuleEngineService;
import com.cmr.util.Constants;
import com.cmr.util.JsonConverter;
import com.cmr.util.UrlHandler;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

/**
 * @author : rajith
 */
@Service
public class RuleEngineServiceImpl implements RuleEngineService {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RuleEngineServiceImpl.class);

    @Autowired
    private RuleRestConfig ruleRestConfig;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Set<String> getAllCollectionNames() {
        logger.info("Try to send GET request to api to find collection names");
        String url = UrlHandler.createUrl(Constants.ESB_RULE_FIND_ALL_COLLECTION_NAMES, ruleRestConfig.getApiHostUrl(), ruleRestConfig.getEsbService());
        logger.info("Url [{}]", url);
        String responseJson = restTemplate.getForObject(url, String.class);
        Response response = JsonConverter.getResponseObject(Response.class, responseJson);
        logger.info("Response from API : [{}]", response.getStatus());
        if(response.getPayLoad() == null) {
            logger.info("Response payload is null.");
            return null;
        }
        Set<String> strings = response.getPayLoad();
        strings.remove(Constants.COLLECTION_SYSTEM_INDEX);
        return strings;
    }
}
