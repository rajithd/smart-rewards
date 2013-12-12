package com.cmr.beans.exeception;

/**
 * @author rajith
 */
public class APIException extends Exception {

    private String errorCode;

    public APIException(String errorCode, String message) {
        this(errorCode, message, null);
    }

    public APIException(String errorCode, String message, Throwable t) {
        super(message, t);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
