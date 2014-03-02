package com.cmr.api.dao.impl;

import com.cmr.api.dao.CampaignRepository;
import com.cmr.api.dao.config.MongoDBConfig;
import com.cmr.beans.campaign.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : rajith
 */
@Repository
public class CampaignRepositoryImpl implements CampaignRepository {

    @Autowired
    private MongoDBConfig mongoDBConfig;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Campaign campaign) {
        mongoTemplate.save(campaign,mongoDBConfig.getCampaignCollectionName());
    }
}
