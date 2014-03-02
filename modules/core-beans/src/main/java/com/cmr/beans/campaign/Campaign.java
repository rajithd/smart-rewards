package com.cmr.beans.campaign;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author rajith
 */
public class Campaign {
    private String id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    private CampaignStatusEnum campaignStatus;
    private WinnerSelectionTypeEnum winnerSelectionType;
    private Boolean isActive;
    private Long createdTime;
    private String smsNotification;
    private CampaignRule campaignRule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CampaignStatusEnum getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(CampaignStatusEnum campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public CampaignRule getCampaignRule() {
        return campaignRule;
    }

    public void setCampaignRule(CampaignRule campaignRule) {
        this.campaignRule = campaignRule;
    }

    public WinnerSelectionTypeEnum getWinnerSelectionType() {
        return winnerSelectionType;
    }

    public void setWinnerSelectionType(WinnerSelectionTypeEnum winnerSelectionType) {
        this.winnerSelectionType = winnerSelectionType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public String getSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(String smsNotification) {
        this.smsNotification = smsNotification;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", campaignStatus=" + campaignStatus +
                ", campaignRule='" + campaignRule + '\'' +
                ", winnerSelectionType=" + winnerSelectionType +
                ", isActive=" + isActive +
                ", createdTime=" + createdTime +
                '}';
    }
}
