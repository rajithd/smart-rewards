package com.cmr.rule.service;

import com.cmr.beans.campaign.Campaign;

import java.util.List;
import java.util.Set;

/**
 * @author : rajith
 */
public interface RuleEngineService {

    /**
     * Find all collection names
     * @return
     */
    public Set<String> getAllCollectionNames();

    /**
     * Find all campaigns
     * @return
     */
    public List<Campaign> findAllCampaigns();

}
