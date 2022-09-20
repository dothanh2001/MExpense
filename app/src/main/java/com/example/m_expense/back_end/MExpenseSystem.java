package com.example.m_expense.back_end;

import android.widget.DatePicker;
import android.widget.Toast;

import com.example.m_expense.front_end.AddExpenseActivity;
import com.example.m_expense.front_end.AddTripActivity;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MExpenseSystem {

    private static MExpenseSystem instance = null;

    Trip currentTrip = null;

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

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public void addTrip() {
        AddTripActivity addTripActivity = AddTripActivity.getInstance();
        String name = String.valueOf(addTripActivity.getNameOfTrip().getText());
        String destination = String.valueOf(addTripActivity.getDestination().getText());
        DatePicker datePicker = addTripActivity.getDatePicker();

        String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();

        String description = String.valueOf(addTripActivity.getDescription().getText());
        boolean isRequireRisk = addTripActivity.getRequireRisk().isChecked();

        if (name.equals("") || destination.equals("")) throw new InvalidParameterException();
        Trip newTrip = new Trip(name, destination, date, description, isRequireRisk);
        tripList.add(newTrip);
        setCurrentTrip(newTrip);
        addTripActivity.clearData();
        Toast.makeText(addTripActivity, "Add Trip Successfully", Toast.LENGTH_LONG).show();
    }

    public void addExpense() {
        Trip trip = currentTrip;
        AddExpenseActivity expenseActivity = AddExpenseActivity.getInstance();
        String kind = String.valueOf(expenseActivity.getKindOfTrip().getText());
        String amount = String.valueOf(expenseActivity.getAmount().getText());
        if (kind.equals("") || Integer.parseInt(amount) < 0) throw new InvalidParameterException();
        trip.setKindOf(kind);
        trip.setAmount(amount);
        Toast.makeText(expenseActivity, "Add Expense succesfully!", Toast.LENGTH_LONG).show();
    }

    public List<Trip> searchTripByName(String name) {
        List<Trip> result = new ArrayList<>();
        for (Trip trip : tripList) {
            if (trip.getName().contains(name)) result.add(trip);
        }
        return result;
    }
}
