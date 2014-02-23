package com.cmr.api.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author : rajith
 */
@Configuration
public class SecurityConfig {

    @Value("${admin.roles}")
    private String adminRoles;

    @Value("${manager.roles}")
    private String managerRoles;

    public List<String> getAdminRoles() {
        return splitRoles(adminRoles);
    }

    public List<String> getManagerRoles() {
        return splitRoles(managerRoles);
    }

    private List<String> splitRoles(String role) {
        String[] strings = role.split(",");
        return Arrays.asList(strings);
    }

}
