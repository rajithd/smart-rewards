package com.cmr.api.service;

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

}
