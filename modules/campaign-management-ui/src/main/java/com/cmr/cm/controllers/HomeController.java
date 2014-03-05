package com.cmr.cm.controllers;

import com.cmr.beans.campaign.Campaign;
import com.cmr.cm.service.CampaignService;
import com.cmr.cm.util.ConversionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : rajith
 */
@Controller
public class HomeController extends AbstractController {

    @Autowired
    private CampaignService campaignService;

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String redirectHome(Model model) throws ParseException {
        List<Campaign> campaigns = campaignService.findAllCampaigns();
        model.addAttribute("campaigns",formatDate(campaigns));
        return "home";
    }

    private List<Campaign> formatDate(List<Campaign> campaigns) throws ParseException {
        if(CollectionUtils.isEmpty(campaigns)){
            return new ArrayList<Campaign>();
        }
        for (Campaign campaign :  campaigns){
            campaign.setStartDateStr(ConversionManager.convertToDate(campaign.getStartDate()));
            campaign.setEndDateStr(ConversionManager.convertToDate(campaign.getEndDate()));
        }
        return campaigns;
    }

}
