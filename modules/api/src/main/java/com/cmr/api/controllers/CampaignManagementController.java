package com.cmr.api.controllers;

import com.cmr.api.service.CampaignManagementService;
import com.cmr.beans.campaign.Campaign;
import com.cmr.beans.common.Success;
import com.cmr.beans.exeception.APIException;
import com.cmr.beans.user.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : rajith
 */
@Controller
public class CampaignManagementController extends AbstractController {

    private final static Logger logger = LoggerFactory.getLogger(DecoderController.class);

    @Autowired
    private CampaignManagementService campaignManagementService;

    @RequestMapping(method = RequestMethod.POST, value = "/user/save", produces = "application/json")
    @ResponseBody
    public ResponseEntity saveUser(@RequestBody UserAccount userAccount) throws APIException {
        logger.info("Processing save user request");
        campaignManagementService.saveUser(userAccount);
        logger.info("Successfully Processed save user request");
        return new ResponseEntity<Success>(Success.SUCCESS_CODE, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/campaign/save", produces = "application/json")
    @ResponseBody
    public ResponseEntity saveCampaign(@RequestBody Campaign campaign) throws APIException {
        logger.info("Processing save campaign request");
        campaignManagementService.saveCampaign(campaign);
        logger.info("Successfully Processed save campaign request");
        return new ResponseEntity<Success>(Success.SUCCESS_CODE, HttpStatus.OK);
    }

}
