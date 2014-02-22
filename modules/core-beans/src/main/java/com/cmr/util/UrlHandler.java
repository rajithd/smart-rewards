package com.cmr.util;

/**
 * @author rajith
 */
public final class UrlHandler {

    private UrlHandler() {
    }

    public static String createUrl(String proxyName, String apiHostUrl, String esbServiceName) {
        return apiHostUrl + esbServiceName + proxyName;
    }

}
