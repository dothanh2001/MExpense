package com.example.m_expense.back_end;


import java.util.Date;

public class Trip {

    String name;
    String destination;
    Date date;
    boolean isRequireRisk;

    public Trip(String name, String destination, Date date, boolean isRequireRisk) {
        this.name = name;
        this.destination = destination;
        this.date = date;
        this.isRequireRisk = isRequireRisk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRequireRisk() {
        return isRequireRisk;
    }

    public void setRequireRisk(boolean requireRisk) {
        isRequireRisk = requireRisk;
    }
}
