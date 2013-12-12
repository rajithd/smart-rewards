package com.cmr.api.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rajith
 */
public class APIAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    protected APIAuthenticationFilter() {
        super("");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        APIAuthenticationToken  apiAuthenticationToken =  new APIAuthenticationToken(extractUsername(request),extractPassword(request));
        return getAuthenticationManager().authenticate(apiAuthenticationToken);
    }

    protected String extractUsername(HttpServletRequest request) {
        return request.getHeader(APIAuthentication.username);
    }

    private String extractPassword(HttpServletRequest request) {
        return request.getHeader(APIAuthentication.password);
    }
}
