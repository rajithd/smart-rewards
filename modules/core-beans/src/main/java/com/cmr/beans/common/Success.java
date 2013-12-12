package com.cmr.beans.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author rajith
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Success {

    public static final Success SUCCESS_CODE = new Success();
    private static final String SUCCESS_KEYWORD = "success";
    private String description;
    private Boolean ok = Boolean.TRUE;
    private String additionalInfo;

    public Success() {
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean value) {
        this.ok = value;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

    public String getDescription() {
        return (ok) ? SUCCESS_KEYWORD : "";
    }

    public void setDescription(String description) {
        this.description = (ok) ? SUCCESS_KEYWORD : "";
    }

}
