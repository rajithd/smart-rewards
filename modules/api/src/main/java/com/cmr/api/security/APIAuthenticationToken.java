package com.cmr.api.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author rajith
 */
public class APIAuthenticationToken implements APIAuthentication{

    private String username;
    private String password;


    public APIAuthenticationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String password() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getCredentials() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getDetails() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getPrincipal() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAuthenticated() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
