package com.cmr.cm.service;

import com.cmr.beans.campaign.Campaign;

import java.util.List;

/**
 * @author : rajith
 */
public interface CampaignService {

    /**
     * Save campagin
     * @param campaign
     */
    public void save(Campaign campaign);

    public List<Campaign> findAllCampaigns();

}
