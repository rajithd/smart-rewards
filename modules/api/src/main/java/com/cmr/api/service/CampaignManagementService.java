package com.cmr.api.service;

import com.cmr.beans.campaign.Campaign;
import com.cmr.beans.exeception.APIException;
import com.cmr.beans.user.UserAccount;

import java.util.List;

/**
 * @author : rajith
 */
public interface CampaignManagementService {

    /**
     * Save user
     * @param userAccount
     */
    public void saveUser(UserAccount userAccount) throws APIException;

    /**
     * Save campagin
     * @param campaign
     */
    public void saveCampaign(Campaign campaign) throws APIException;

    /**
     * Find all campaigns
     * @throws APIException
     */
    public List<Campaign> findAllCampaign() throws APIException;

}
