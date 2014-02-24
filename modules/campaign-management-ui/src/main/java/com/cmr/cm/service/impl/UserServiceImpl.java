package com.cmr.cm.service.impl;

import com.cmr.beans.user.UserAccount;
import com.cmr.cm.config.CampaignRestConfig;
import com.cmr.cm.service.UserService;
import com.cmr.util.Constants;
import com.cmr.util.UrlHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : rajith
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CampaignRestConfig campaignRestConfig;


    @Override
    public void saveUser(UserAccount userAccount) {
        logger.info("Try to save user : [{}]", userAccount.getUsername());
        String url = UrlHandler.createUrl(Constants.ESB_SERVICE_CREATE_USER, campaignRestConfig.getApiHostUrl(), campaignRestConfig.getEsbService());
        logger.info("Create url  : [{}]", url);
        String response = restTemplate.postForObject(url, userAccount, String.class);
        logger.info("Response : [{}]", response);
    }
}
