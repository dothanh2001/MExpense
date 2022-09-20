package com.example.m_expense.back_end;

public class Trip {

    String name = "";
    String destination = "";
    String date = "";
    String description = "";
    boolean isRequireRisk;

    String amount = "";
    String kindOf = "";

    public Trip(String name, String destination, String date, String description, boolean isRequireRisk) {
        this.name = name;
        this.destination = destination;
        this.date = date;
        this.description = description;
        this.isRequireRisk = isRequireRisk;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getKindOf() {
        return kindOf;
    }

    public void setKindOf(String kindOf) {
        this.kindOf = kindOf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRequireRisk() {
        return isRequireRisk;
    }

    public void setRequireRisk(boolean requireRisk) {
        isRequireRisk = requireRisk;
    }
}
