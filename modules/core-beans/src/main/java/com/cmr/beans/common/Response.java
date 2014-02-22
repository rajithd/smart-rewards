package com.cmr.beans.common;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Set;

/**
 * @author : rajith
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private Integer status;
    private Set<String> payLoad;

    public Response(Integer status, Set<String> payLoad) {
        this.status = status;
        this.payLoad = payLoad;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<String> getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(Set<String> payLoad) {
        this.payLoad = payLoad;
    }
}
