package com.example.m_expense.front_end;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.m_expense.R;

public class AddTripActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtrip);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(event-> {
            System.out.println("Thanh");
        });

    }

}
