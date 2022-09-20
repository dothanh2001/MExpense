package com.example.m_expense.front_end;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddExpenseActivity extends AppCompatActivity {


    private static AddExpenseActivity instance = null;

    public static AddExpenseActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
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
}
