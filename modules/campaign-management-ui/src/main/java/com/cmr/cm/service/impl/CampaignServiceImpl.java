package com.cmr.cm.service.impl;

import com.cmr.beans.campaign.Campaign;
import com.cmr.cm.config.CampaignRestConfig;
import com.cmr.cm.service.CampaignService;
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
public class CampaignServiceImpl implements CampaignService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CampaignRestConfig campaignRestConfig;

    @Override
    public void save(Campaign campaign) {
        logger.info("Try to save campaign : [{}]", campaign.getName());
        String url = UrlHandler.createUrl(Constants.ESB_SERVICE_CREATE_CAMPAIGN, campaignRestConfig.getApiHostUrl(), campaignRestConfig.getEsbService());
        logger.info("Create url  : [{}]", url);
        String response = restTemplate.postForObject(url, campaign, String.class);
        logger.info("Response : [{}]", response);
    }
}
