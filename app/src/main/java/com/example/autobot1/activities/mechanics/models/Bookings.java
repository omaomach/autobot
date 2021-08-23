package com.example.autobot1.activities.mechanics.models;

public class Bookings {
    private String bookedBy,byName,byImageUrl,bookedTo,meetUpTime,pickUpTime;
    private boolean isComplete;

    public Bookings(String bookedBy,String byName,String byImageUrl, String bookedTo, String meetUpTime, String pickUpTime,boolean isComplete) {
        this.bookedBy = bookedBy;
        this.byName = byName;
        this.byImageUrl = byImageUrl;
        this.bookedTo = bookedTo;
        this.meetUpTime = meetUpTime;
        this.pickUpTime = pickUpTime;
        this.isComplete = isComplete;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public String getByImageUrl() {
        return byImageUrl;
    }

    public void setByImageUrl(String byImageUrl) {
        this.byImageUrl = byImageUrl;
    }

    public String getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(String bookedTo) {
        this.bookedTo = bookedTo;
    }

    public String getMeetUpTime() {
        return meetUpTime;
    }

    public void setMeetUpTime(String meetUpTime) {
        this.meetUpTime = meetUpTime;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
