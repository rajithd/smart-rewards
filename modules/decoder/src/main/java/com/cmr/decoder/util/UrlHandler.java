package com.cmr.decoder.util;

import com.cmr.decoder.config.RestConfig;

/**
 * @author rajith
 */
public final class UrlHandler {

    public static String createUrl(String proxyName, RestConfig restConfig) {
        return restConfig.getApiHostUrl() + restConfig.getEsbService() + proxyName;
    }

}
