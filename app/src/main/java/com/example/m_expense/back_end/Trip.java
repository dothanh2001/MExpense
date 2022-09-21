package com.example.m_expense.back_end;

import java.util.ArrayList;
import java.util.List;

public class Trip {

    String name = "";
    String startDestination = "";
    String endDestination = "";
    String startDate = "";
    String endDate ="";
    String description = "";
    boolean isRequireRisk;

    int amount = 0;
    String kindOf = "";

    List<Expense> expenseList = new ArrayList<>();

    public Trip(String name, String startDestination, String endDestination, String startDate, String endDate, String description, boolean isRequireRisk) {
        this.name = name;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.isRequireRisk = isRequireRisk;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDestination() {
        return endDestination;
    }

    public void setEndDestination(String endDestination) {
        this.endDestination = endDestination;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public String getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(String startDestination) {
        this.startDestination = startDestination;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public boolean isRequireRisk() {
        return isRequireRisk;
    }

    public void setRequireRisk(boolean requireRisk) {
        isRequireRisk = requireRisk;
    }
}
