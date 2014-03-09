package com.cmr.rule.service;

import com.cmr.beans.campaign.Campaign;
import com.cmr.beans.campaign.CampaignRule;

/**
 * @author rajith
 */
public class RuleSQLSummery {


    public String ruleExecuteSql(Campaign campaign) {
        if (campaign == null || campaign.getCampaignRule() == null) {
            return null;
        }
        CampaignRule rule = campaign.getCampaignRule();
        StringBuilder ruleBuilder = new StringBuilder();
        ruleBuilder.append("SELECT ");
        ruleBuilder.append("caller, COUNT(*) AS CNT ");
        ruleBuilder.append("FROM " + rule.getRuleType() + " ");
        ruleBuilder.append("GROUP BY caller ");
        ruleBuilder.append("HAVING CNT " + rule.getConditionString() + " " + rule.getCount());
        return ruleBuilder.toString();
    }


}
