package com.example.m_expense.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.m_expense.R;
import com.example.m_expense.back_end.MExpenseSystem;

public class MainActivity extends AppCompatActivity {

    MExpenseSystem system;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        system = MExpenseSystem.getInstance();
        setContentView(R.layout.activity_main);
        Button insert = (Button) findViewById(R.id.insertButton);
        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddTripActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
//                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("RESTART MAIN ACTIVITY");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("RESUME MAIN ACTIVITY");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Stop MAIN ACTIVITY");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("DESTROY MAIN ACTIVITY");
    }
}