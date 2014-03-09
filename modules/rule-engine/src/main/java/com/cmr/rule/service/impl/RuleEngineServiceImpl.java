package com.cmr.rule.service.impl;

import com.cmr.beans.campaign.Campaign;
import com.cmr.beans.common.Response;
import com.cmr.rule.config.RuleRestConfig;
import com.cmr.rule.service.RuleEngineService;
import com.cmr.rule.util.DateTypeAdapter;
import com.cmr.util.Constants;
import com.cmr.util.JsonConverter;
import com.cmr.util.UrlHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
        Set<String> finalSet = new HashSet<String>();
        for (String collection : strings){
            if(isValidCollection(collection)){
                finalSet.add(collection);
            }
        }
        return finalSet;
    }

    private boolean isValidCollection(String tableName) {
        return Constants.COLLECTION_SMS_NAME.equals(tableName) ||
                Constants.COLLECTION_ACTIVATION_NAME.equals(tableName) || Constants.COLLECTION_VOICE_CALL_NAME.equals(tableName)
                || Constants.COLLECTION_REGISTRATON_NAME.equals(tableName);
    }

    @Override
    public List<Campaign> findAllCampaigns() {
        logger.info("Try to get all campaigns");
        String url = UrlHandler.createUrl(Constants.ESB_SERVICE_GET_CAMPAIGNS, ruleRestConfig.getApiHostUrl(), ruleRestConfig.getEsbService());
        logger.info("Create url  : [{}]", url);
        String response = restTemplate.getForObject(url, String.class);
        logger.info("Response : [{}]", response);
        Type type = new TypeToken<List<Campaign>>() {
        }.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateTypeAdapter());
        Gson gson = gsonBuilder.create();
        return gson.fromJson(response, type);
    }
}
