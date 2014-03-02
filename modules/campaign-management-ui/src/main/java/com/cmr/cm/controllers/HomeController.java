package com.cmr.cm.controllers;

import com.cmr.beans.campaign.Campaign;
import com.cmr.cm.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author : rajith
 */
@Controller
public class HomeController extends AbstractController {

    @Autowired
    private CampaignService campaignService;

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String redirectHome(Model model) {
        List<Campaign> campaigns = campaignService.findAllCampaigns();
        model.addAttribute("campaigns",campaigns);
        return "home";
    }
}
