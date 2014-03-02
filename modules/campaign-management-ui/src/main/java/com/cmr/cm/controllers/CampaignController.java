package com.cmr.cm.controllers;

import com.cmr.beans.campaign.Campaign;
import com.cmr.cm.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : rajith
 */
@Controller
public class CampaignController extends AbstractController {

    @Autowired
    private CampaignService campaignService;

    @RequestMapping(method = RequestMethod.GET, value = "/create-campaign")
    public String redirectCreateCampaign() {
        return "create-campaign";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create-campaign")
    public String submitCreateCampaign(Campaign campaign) {
        campaignService.save(campaign);
        return "create-campaign";
    }

}
