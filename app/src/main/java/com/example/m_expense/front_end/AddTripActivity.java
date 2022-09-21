package com.example.m_expense.front_end;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m_expense.R;
import com.example.m_expense.back_end.MExpenseSystem;

public class AddTripActivity extends AppCompatActivity {

    EditText nameOfTrip;
    EditText start_destination;
    EditText end_destination;
    DatePicker datePicker;
    DatePicker datePickerEnd;
    EditText description;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch requireRisk;
    Button button;


    private static AddTripActivity instance = null;

    public static AddTripActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtrip);

        instance = this;

        nameOfTrip = findViewById(R.id.kindOfTrip);
        start_destination = findViewById(R.id.start_destination);
        end_destination = findViewById(R.id.end_destination);
        datePicker = findViewById(R.id.datePicker);
        datePickerEnd = findViewById(R.id.datePickerEnd);
        description = findViewById(R.id.description);
        requireRisk = findViewById(R.id.requireRisk);


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(event-> {
            System.out.println("Thanh");
            System.out.println(nameOfTrip.getText());
            System.out.println(start_destination.getText());
            System.out.println(datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear());
            System.out.println(description.getText());
            System.out.println(requireRisk.isChecked());

            try {
                MExpenseSystem.getInstance().addTrip();

                Intent intent = new Intent(this, AddExpenseActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(AddTripActivity.getInstance(), "Add Trip Failed!", Toast.LENGTH_LONG).show();
            }


        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("RESTART ADD TRIP ACTIVITY");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUME ADD TRIP ACTIVITY");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Stop ADD TRIP ACTIVITY");
        instance = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("DESTROY ADD TRIP ACTIVITY");
        instance = null;
    }

    public void clearData() {
        nameOfTrip.getText().clear();
        start_destination.getText().clear();
        description.getText().clear();
        requireRisk.setChecked(false);
    }

    public EditText getEnd_destination() {
        return end_destination;
    }

    public void setEnd_destination(EditText end_destination) {
        this.end_destination = end_destination;
    }

    public DatePicker getDatePickerEnd() {
        return datePickerEnd;
    }

    public EditText getNameOfTrip() {
        return nameOfTrip;
    }

    public EditText getStart_destination() {
        return start_destination;
    }


    public DatePicker getDatePicker() {
        return datePicker;
    }

    public EditText getDescription() {
        return description;
    }

    public Switch getRequireRisk() {
        return requireRisk;
    }

    public Button getButton() {
        return button;
    }
}
