package com.example.m_expense.front_end;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.m_expense.R;
import com.example.m_expense.back_end.MExpenseSystem;

public class AddExpenseActivity extends AppCompatActivity {

    TextView nameOfTrip;
    EditText kindOfTrip;
    EditText amount;
    Button button;

    private static AddExpenseActivity instance = null;

    public static AddExpenseActivity getInstance() {
        return instance;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_add_expense);

        instance = this;

        nameOfTrip = findViewById(R.id.nameOfTrip);
        kindOfTrip = findViewById(R.id.kindOfTrip);
        amount = findViewById(R.id.amount);
        button = findViewById(R.id.button);

        nameOfTrip.setText(MExpenseSystem.getInstance().getCurrentTrip().getName());
        button.setOnClickListener(event -> {
            try {
                MExpenseSystem.getInstance().addExpense(MExpenseSystem.getInstance().getCurrentTrip());
                clear();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Add Expense to trip " + MExpenseSystem.getInstance().getCurrentTrip().getName() + " failed!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void clear() {
        kindOfTrip.getText().clear();
        amount.getText().clear();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("RESTART ADD EXPENSE ACTIVITY");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUME ADD EXPENSE ACTIVITY");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Stop ADD EXPENSE ACTIVITY");
    }

    public TextView getNameOfTrip() {
        return nameOfTrip;
    }

    public EditText getKindOfTrip() {
        return kindOfTrip;
    }

    public EditText getAmount() {
        return amount;
    }

    public Button getButton() {
        return button;
    }
}
