package com.cmr.cm.controllers;

import com.cmr.beans.campaign.Campaign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : rajith
 */
@Controller
public class CampaignController extends AbstractController {

    @RequestMapping(method = RequestMethod.GET, value = "/create-campaign")
    public String redirectCreateCampaign() {
        return "create-campaign";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-campaign")
    public String submitCreateCampaign(Campaign campaign) {
        return "create-campaign";
    }

}
