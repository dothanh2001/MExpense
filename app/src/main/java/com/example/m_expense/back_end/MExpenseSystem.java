package com.example.m_expense.back_end;

import android.widget.DatePicker;

import com.example.m_expense.front_end.AddTripActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MExpenseSystem {

    public static MExpenseSystem instance = null;

    List<Trip> tripList = new ArrayList<>();

    public static MExpenseSystem getInstance() {
        if (instance == null) {
            instance = new MExpenseSystem();
        }
        return instance;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public void addTrip() {
        AddTripActivity addTripActivity = AddTripActivity.getInstance();
        String name = String.valueOf(addTripActivity.getNameOfTrip().getText());
        String destination = String.valueOf(addTripActivity.getDestination().getText());

        DatePicker datePicker = addTripActivity.getDatePicker();
        Date date = new Date(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        boolean isRequireRisk = addTripActivity.getRequireRisk().isChecked();

        tripList.add(new Trip(name, destination, date, isRequireRisk));
    }
}
