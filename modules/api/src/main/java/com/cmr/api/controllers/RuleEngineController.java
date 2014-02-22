package com.cmr.api.controllers;

import com.cmr.api.service.RuleService;
import com.cmr.beans.common.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * @author : rajith
 */
@Controller
public class RuleEngineController extends AbstractController {

    private final static Logger logger = LoggerFactory.getLogger(RuleEngineController.class);

    @Autowired
    private RuleService ruleService;

    @RequestMapping(method = RequestMethod.GET, value = "/rule/collection/names", produces = "application/json")
    @ResponseBody
    public Response getAllCollectionNames() {
        logger.info("Processing get all collection request");
        Set<String> strings = ruleService.getAllCollectionName();
        logger.info("Successfully process get all collection request");
        return new Response(HttpStatus.OK.value(),strings);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/rule/collection/columns/{collectionName}", produces = "application/json")
    @ResponseBody
    public Response getCollectionColumnsByCollectionName(@PathVariable(value = "collectionName") String collectionName) {
        logger.info("Processing get collection columns request");
        Set<String> strings = ruleService.getCollectionColumnsByName(collectionName);
        logger.info("Successfully process get collection columns request");
        return new Response(HttpStatus.OK.value(),strings);
    }



}
