package com.example.m_expense.back_end;

import android.widget.DatePicker;
import android.widget.Toast;

import com.example.m_expense.front_end.AddTripActivity;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MExpenseSystem {

    public static MExpenseSystem instance = null;

    List<Trip> tripList = new ArrayList<>();

    public static MExpenseSystem getInstance() {
        if (instance == null) {
            instance = new MExpenseSystem();
            instance.tripList.add(new Trip(
                    "default name",
                    "default destination",
                    "10/01/2022",
                    "no description",
                    true));
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
        try {
            AddTripActivity addTripActivity = AddTripActivity.getInstance();
            String name = String.valueOf(addTripActivity.getNameOfTrip().getText());
            String destination = String.valueOf(addTripActivity.getDestination().getText());

            DatePicker datePicker = addTripActivity.getDatePicker();
            String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();

            String description = String.valueOf(addTripActivity.getDescription().getText());
            boolean isRequireRisk = addTripActivity.getRequireRisk().isChecked();

            if (name.equals("") || description.equals("")) throw new InvalidParameterException();
            tripList.add(new Trip(name, destination, date, description, isRequireRisk));

            addTripActivity.clearData();
            Toast.makeText(addTripActivity, "Add Trip Successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(AddTripActivity.getInstance(), "Add Trip Failed!", Toast.LENGTH_LONG).show();
        }
    }
}
