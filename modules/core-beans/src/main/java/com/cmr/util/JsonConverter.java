package com.cmr.util;

import com.google.gson.Gson;

/**
 * @author : rajith
 */
public final class JsonConverter {

    private JsonConverter() {
    }

    public static <T> T getResponseObject(Class<T> classType, String json){
        return new Gson().fromJson(json, classType);
    }

}
