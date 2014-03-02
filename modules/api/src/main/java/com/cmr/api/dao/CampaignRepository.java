package com.cmr.api.dao;

import com.cmr.beans.campaign.Campaign;

/**
 * @author : rajith
 */
public interface CampaignRepository {

    /**
     * Save campagin
     * @param campaign
     */
    public void save(Campaign campaign);
}
