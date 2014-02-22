package com.cmr.auth.dao;


import com.cmr.beans.user.UserAccount;

public interface UserRepository {

    public UserAccount findUserAccountByUsername(String username);

}
