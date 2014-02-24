package com.cmr.cm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author rajith
 */
public abstract class AbstractController {

    private final static Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @ExceptionHandler(Exception.class)
    public String handleException1(Exception e) {
        logger.error("Unknown exception : ", e);
        return "error/error";
    }

}
