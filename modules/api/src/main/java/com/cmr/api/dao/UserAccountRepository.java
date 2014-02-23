package com.cmr.api.dao;

import com.cmr.beans.user.UserAccount;

/**
 * @author : rajith
 */
public interface UserAccountRepository {

    /**
     * Save user
     * @param userAccount
     */
    public void save(UserAccount userAccount);

}
