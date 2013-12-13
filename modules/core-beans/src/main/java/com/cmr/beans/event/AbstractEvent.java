package com.cmr.beans.event;

/**
 * @author rajith
 */
public abstract class AbstractEvent {

    private String id;
    private String callerId;
    private String calleeId;
    private String userId;
    private Integer evenYear;
    private Integer eventMonth;
    private Integer eventDayOfMonth;
    private Integer eventHour;
    private Integer eventMinute;
    private Integer eventSeconds;
    private String eventResults;
    private Integer originatingZoneCode;
    private Integer destinationZoneCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getEvenYear() {
        return evenYear;
    }

    public void setEvenYear(Integer evenYear) {
        this.evenYear = evenYear;
    }

    public Integer getEventMonth() {
        return eventMonth;
    }

    public void setEventMonth(Integer eventMonth) {
        this.eventMonth = eventMonth;
    }

    public Integer getEventDayOfMonth() {
        return eventDayOfMonth;
    }

    public void setEventDayOfMonth(Integer eventDayOfMonth) {
        this.eventDayOfMonth = eventDayOfMonth;
    }

    public Integer getEventHour() {
        return eventHour;
    }

    public void setEventHour(Integer eventHour) {
        this.eventHour = eventHour;
    }

    public Integer getEventMinute() {
        return eventMinute;
    }

    public void setEventMinute(Integer eventMinute) {
        this.eventMinute = eventMinute;
    }

    public Integer getEventSeconds() {
        return eventSeconds;
    }

    public void setEventSeconds(Integer eventSeconds) {
        this.eventSeconds = eventSeconds;
    }

    public String getEventResults() {
        return eventResults;
    }

    public void setEventResults(String eventResults) {
        this.eventResults = eventResults;
    }

    public Integer getOriginatingZoneCode() {
        return originatingZoneCode;
    }

    public void setOriginatingZoneCode(Integer originatingZoneCode) {
        this.originatingZoneCode = originatingZoneCode;
    }

    public Integer getDestinationZoneCode() {
        return destinationZoneCode;
    }

    public void setDestinationZoneCode(Integer destinationZoneCode) {
        this.destinationZoneCode = destinationZoneCode;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getCalleeId() {
        return calleeId;
    }

    public void setCalleeId(String calleeId) {
        this.calleeId = calleeId;
    }

    @Override
    public String toString() {
        return "AbstractEvent{" +
                "id='" + id + '\'' +
                ", callerId='" + callerId + '\'' +
                ", calleeId='" + calleeId + '\'' +
                ", userId='" + userId + '\'' +
                ", evenYear=" + evenYear +
                ", eventMonth=" + eventMonth +
                ", eventDayOfMonth=" + eventDayOfMonth +
                ", eventHour=" + eventHour +
                ", eventMinute=" + eventMinute +
                ", eventSeconds=" + eventSeconds +
                ", eventResults='" + eventResults + '\'' +
                ", originatingZoneCode=" + originatingZoneCode +
                ", destinationZoneCode=" + destinationZoneCode +
                '}';
    }
}
