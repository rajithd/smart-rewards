package com.cmr.api.security;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rajith
 */
public class APIExceptionTranslationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Error error = null;
        try {
            filterChain.doFilter(request, response);
            logger.debug("Chain processed normally");
        } catch (IOException ex) {
            logger.error("Error while processing filter chain", ex);
            throw ex;
        } catch (Exception ex) {
            logger.debug("Exception while processing request", ex);
        }
    }


}
