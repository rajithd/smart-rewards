package com.cmr.api.security;

import org.springframework.security.core.Authentication;

/**
 * @author rajith
 */
public interface APIAuthentication extends Authentication {

    public static final String username = "username";
    public static final String password = "password";

    public String getUsername();

    public String password();

}
