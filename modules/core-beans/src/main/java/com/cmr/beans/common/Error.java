package com.cmr.beans.common;

/**
 * @author rajith
 */
public class Error {

    public Error() {
    }

    public Error(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;
    private String additionalInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }


    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

}
