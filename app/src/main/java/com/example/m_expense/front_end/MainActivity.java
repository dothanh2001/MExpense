package com.example.m_expense.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.m_expense.R;
import com.example.m_expense.back_end.MExpenseSystem;
import com.example.m_expense.back_end.TripListViewAdapter;

public class MainActivity extends AppCompatActivity {

    MExpenseSystem system;

    TripListViewAdapter tripListViewAdapter;
    ListView listViewTrip;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        system = MExpenseSystem.getInstance();

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

        tripListViewAdapter = new TripListViewAdapter(system.getTripList());
        listViewTrip = findViewById(R.id.listTrip);
        listViewTrip.setAdapter(tripListViewAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("RESTART MAIN ACTIVITY");
        tripListViewAdapter = new TripListViewAdapter(system.getTripList());
        listViewTrip = findViewById(R.id.listTrip);
        listViewTrip.setAdapter(tripListViewAdapter);
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