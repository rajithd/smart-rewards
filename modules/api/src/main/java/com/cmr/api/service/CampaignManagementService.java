package com.cmr.api.service;

import com.cmr.beans.campaign.Campaign;
import com.cmr.beans.exeception.APIException;
import com.cmr.beans.user.UserAccount;

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

}
