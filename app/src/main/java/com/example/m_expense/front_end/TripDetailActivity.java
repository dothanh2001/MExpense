package com.example.m_expense.front_end;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.m_expense.R;
import com.example.m_expense.back_end.MExpenseSystem;

public class TripDetailActivity extends AppCompatActivity {

    TextView name;

    TextView amount;
    EditText startDestionation;
    EditText endDestination;
    EditText startDate;
    EditText endDate;
    EditText description;
    Switch requireRisk;

    EditText kindOfTrip;

    private static TripDetailActivity instance = null;

    public static TripDetailActivity getInstance() {
        return instance;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_trip);

        instance = this;

        name = findViewById(R.id.nameOfTrip);
        startDestionation = findViewById(R.id.start_destination);
        endDestination = findViewById(R.id.end_destination);
        startDate = findViewById(R.id.start_date);
        endDate = findViewById(R.id.end_date);
        description = findViewById(R.id.description);
        requireRisk = findViewById(R.id.requireRisk);
        amount = findViewById(R.id.amount);
//        kindOfTrip = findViewById(R.id.kindOfTrip);

        MExpenseSystem.getInstance().viewDetail( MExpenseSystem.getInstance().getCurrentTrip());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("RESTART DETAIL TRIP ACTIVITY");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUME DETAIL TRIP ACTIVITY");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Stop DETAIL TRIP ACTIVITY");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("DESTROY DETAIL TRIP ACTIVITY");
    }

    public TextView getName() {
        return name;
    }

    public Switch getRequireRisk() {
        return requireRisk;
    }

    public TextView getAmount() {
        return amount;
    }


    public EditText getKindOfTrip() {
        return kindOfTrip;
    }

    public void setKindOfTrip(EditText kindOfTrip) {
        this.kindOfTrip = kindOfTrip;
    }

    public EditText getStartDestionation() {
        return startDestionation;
    }

    public void setStartDestionation(EditText startDestionation) {
        this.startDestionation = startDestionation;
    }

    public EditText getEndDestination() {
        return endDestination;
    }

    public void setEndDestination(EditText endDestination) {
        this.endDestination = endDestination;
    }

    public EditText getStartDate() {
        return startDate;
    }

    public void setStartDate(EditText startDate) {
        this.startDate = startDate;
    }

    public EditText getEndDate() {
        return endDate;
    }

    public void setEndDate(EditText endDate) {
        this.endDate = endDate;
    }

    public EditText getDescription() {
        return description;
    }

    public void setDescription(EditText description) {
        this.description = description;
    }
}
