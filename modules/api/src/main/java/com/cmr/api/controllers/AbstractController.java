package com.cmr.api.controllers;

import com.cmr.beans.common.Error;
import com.cmr.beans.exeception.APIException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rajith
 */
public abstract class AbstractController {

    @ExceptionHandler(APIException.class)
    @ResponseBody
    public Error handleException(APIException e, HttpServletRequest request, HttpServletResponse response) {
        Error error = new Error();
        error.setCode(e.getErrorCode());
        error.setDescription("");
        error.setAdditionalInfo(e.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return (error);
    }

}
