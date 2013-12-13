package com.cmr.decoder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author rajith
 */
@Component
public class RestConfig {

    @Value("${api.host.port}")
    private String apiHostUrl;
    @Value("${esb.service}")
    private String esbService;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getApiHostUrl() {
        return apiHostUrl;
    }

    public String getEsbService() {
        return esbService;
    }
}
