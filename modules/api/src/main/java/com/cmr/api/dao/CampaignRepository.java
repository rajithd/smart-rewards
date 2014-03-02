package com.cmr.api.dao;

import com.cmr.beans.campaign.Campaign;

import java.util.List;

/**
 * @author : rajith
 */
public interface CampaignRepository {

    /**
     * Save campagin
     * @param campaign
     */
    public void save(Campaign campaign);

    /**
     * Find all campagins
     * @return
     */
    public List<Campaign> findAll();
}
