package com.example.m_expense.back_end;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.m_expense.database.SQLHelper;
import com.example.m_expense.front_end.AddExpenseActivity;
import com.example.m_expense.front_end.AddTripActivity;
import com.example.m_expense.front_end.MainActivity;
import com.example.m_expense.front_end.TripDetailActivity;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class MExpenseSystem {

    private static MExpenseSystem instance = null;

    Trip currentTrip = null;

    List<Trip> tripList = new ArrayList<>();


    public static MExpenseSystem getInstance() {
        if (instance == null) {
            instance = new MExpenseSystem();
//            instance.tripList.add(new Trip(
//                    "default name",
//                    "default destination",
//                    "10/01/2022",
//                    "no description",
//                    true));
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
        String startDestination = String.valueOf(addTripActivity.getStart_destination().getText());
        String endDestination = String.valueOf(addTripActivity.getEnd_destination().getText());
        DatePicker datePicker = addTripActivity.getDatePicker();
        DatePicker datePickerEnd = addTripActivity.getDatePickerEnd();

        String startDate = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
        String endDate = datePickerEnd.getDayOfMonth() + "/" + (datePickerEnd.getMonth() + 1) + "/" + datePickerEnd.getYear();

        String description = String.valueOf(addTripActivity.getDescription().getText());
        boolean isRequireRisk = addTripActivity.getRequireRisk().isChecked();

        if (name.equals("") || startDestination.equals("")) throw new InvalidParameterException();
        Trip newTrip = new Trip(name, startDestination, endDestination, startDate, endDate, description, isRequireRisk);
        tripList.add(newTrip);
        addTripToDatabase(newTrip);
        setCurrentTrip(newTrip);
        addTripActivity.clearData();
        Toast.makeText(addTripActivity, "Add Trip Successfully", Toast.LENGTH_LONG).show();
    }

    public void addExpense(Trip trip) {
        AddExpenseActivity expenseActivity = AddExpenseActivity.getInstance();
        String kind = String.valueOf(expenseActivity.getKindOfTrip().getText());
        String amount = String.valueOf(expenseActivity.getAmount().getText());
        if (kind.equals("")) throw new InvalidParameterException();
        trip.setKindOf(kind);
        trip.setAmount(trip.getAmount() + Integer.parseInt(amount));

        Expense expense = new Expense(amount, kind);
        trip.getExpenseList().add(expense);
        addExpenseToDatabaseByTrip(trip, expense);
        Toast.makeText(expenseActivity, "Add Expense to trip " + trip.getName() + " succesfully!", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    public void viewDetail(Trip trip) {
        TripDetailActivity tripDetailActivity = TripDetailActivity.getInstance();
//        tripDetailActivity.getAmount().setText(String.valueOf(currentTrip.getAmount()));
//        tripDetailActivity.getKindOfTrip().setText(currentTrip.getKindOf());
        tripDetailActivity.getName().setText(trip.getName());
        tripDetailActivity.getAmount().setText("Total Amount: " + trip.getAmount());
        tripDetailActivity.getStartDate().setText(trip.getStartDate());
        tripDetailActivity.getEndDate().setText(trip.getEndDate());
        tripDetailActivity.getStartDestionation().setText(trip.getStartDestination());
        tripDetailActivity.getEndDestination().setText(trip.getEndDestination());
        tripDetailActivity.getDescription().setText(trip.getDescription());
        tripDetailActivity.getRequireRisk().setChecked(trip.isRequireRisk());
    }

    public void prepareDatabase() {
        SQLHelper helper = SQLHelper.getInstance();
        //create table Trip
        helper.queryData("CREATE TABLE  IF NOT EXISTS Trip(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200), " +
                "start_destination VARCHAR(200), end_destination VARCHAR(200), " +
                "start_date VARCHAR(200), end_date VARCHAR(200), " +
                "description VARCHAR(200), requireRisk INTEGER)");

        //create table Expense
        helper.queryData("CREATE TABLE  IF NOT EXISTS Expense(" +
                "tripID INTEGER, kindOf VARCHAR(200), amount INTEGER)");
//
//        helper.queryData("INSERT INTO Trip VALUES(null" + ", \'" + "Food tour" + "\'"
//                + ", \'" + "Ha Noi" + "\'" + ", \'" + "Hai Phong" + "\'"
//                + ", \'" + "21/9/2022" + "\'" + ", \'" + "30/9/2022" + "\'"
//                + ", \'" + "food tour mien Bac" + "\'" + ", \'" + 1 + "\'" +  ")");
//        helper.queryData("INSERT INTO Trip VALUES(null, \'Cua Lo - Nghe An\')");
        // remove DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';

        Cursor cursor = helper.getData("SELECT * FROM Trip");
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String startDestination = cursor.getString(2);
            String endDestination = cursor.getString(3);
            String startDate = cursor.getString(4);
            String endDate = cursor.getString(5);
            String description = cursor.getString(6);
            boolean isRequireRisk = cursor.getInt(7) == 1;

            Trip trip = new Trip(name, startDestination, endDestination, startDate, endDate, description, isRequireRisk);
            tripList.add(trip);

            Toast.makeText(MainActivity.getInstance(), name, Toast.LENGTH_LONG).show();
        }
    }

    public void addTripToDatabase(Trip trip) {
        SQLHelper helper = SQLHelper.getInstance();
        String query = "INSERT INTO Trip VALUES(null" + ", \'" + trip.getName() + "\'"
                + ", \'" + trip.getStartDestination() + "\'" + ", \'" + trip.getEndDestination() + "\'"
                + ", \'" + trip.getStartDate() + "\'" + ", \'" + trip.getEndDate() + "\'"
                + ", \'" + trip.getDescription() + "\'" + ", \'" + (trip.isRequireRisk() ? 1 : 0) + "\'" +  ")";
        System.out.println(query);
        helper.queryData(query);


        for (Expense expense : trip.getExpenseList()) {
            addExpenseToDatabaseByTrip(trip, expense);
        }

    }

    public void addExpenseToDatabaseByTrip(Trip trip, Expense expense) {

        SQLHelper helper = SQLHelper.getInstance();

        // get ID of trip
        String query = "SELECT Id FROM Trip WHERE name = " + "\"" + trip.getName() + "\";";
        Cursor cursor = helper.getData(query);
        String id = "";
        while (cursor.moveToNext()) {
            id = cursor.getString(0);
            System.out.println("ID of Trip in database = " + id);
        }

        query = "INSERT INTO Expense VALUES(" + id
                + ", \'" + expense.getKindOf() + "\'" + ", \'" + expense.getAmount() + "\'"
                +  ")";
        System.out.println(query);
        helper.queryData(query);
    }

    public List<Trip> searchTripByName(String name) {
        List<Trip> result = new ArrayList<>();
        for (Trip trip : tripList) {
            if (trip.getName().contains(name)) result.add(trip);
        }
        return result;
    }
}
