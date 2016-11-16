package com.example.jairbsena.raliuninorte;

/**
 * Created by ftorrenegra on 16/11/16.
 */

public class Report {
    public String userName;
    public String groupUser;
    public int placesFind;
    public int pointsTotal;
    public long timeTotal;

    public Report() {
    }

    public Report(String userName, String groupUser, int placesFind, int pointsTotal, long timeTotal) {
        this.userName = userName;
        this.groupUser = groupUser;
        this.placesFind = placesFind;
        this.pointsTotal = pointsTotal;
        this.timeTotal = timeTotal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(String groupUser) {
        this.groupUser = groupUser;
    }

    public int getPlacesFind() {
        return placesFind;
    }

    public void setPlacesFind(int placesFind) {
        this.placesFind = placesFind;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public long getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(long timeTotal) {
        this.timeTotal = timeTotal;
    }
}
