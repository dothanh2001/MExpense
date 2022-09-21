package com.example.m_expense.front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.m_expense.R;
import com.example.m_expense.back_end.MExpenseSystem;
import com.example.m_expense.back_end.Trip;
import com.example.m_expense.back_end.TripListViewAdapter;
import com.example.m_expense.database.SQLHelper;

import java.util.List;

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
                startActivity(intent);
            }
        });

        tripListViewAdapter = new TripListViewAdapter(system.getTripList());
        listViewTrip = findViewById(R.id.listTrip);
        listViewTrip.setAdapter(tripListViewAdapter);
        listViewTrip.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView <?> parentAdapter, View view, int position,
                                    long id) {

                //  Place code here with the action
                List<Trip> listTrip = system.getTripList();
                Trip trip = listTrip.get(position);
                Toast.makeText(MainActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
                system.setCurrentTrip(trip);
                Intent intent = new Intent(view.getContext(), TripDetailActivity.class);
                startActivity(intent);
//                system.viewDetail();

            }
        });
//        SQLHelper helper = new SQLHelper(this, "test.sqlite", null, 1);
//        helper.queryData("CREATE TABLE  IF NOT EXISTS Trip(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(200))");
//        helper.queryData("INSERT INTO Trip VALUES(null, \'Ha Long Tour\')");
//        helper.queryData("INSERT INTO Trip VALUES(null, \'Cua Lo - Nghe An\')");
//
//        Cursor cursor = helper.getData("SELECT * FROM Trip");
//        while (cursor.moveToNext()) {
//            String name = cursor.getString(1);
//            Toast.makeText(this, name, Toast.LENGTH_LONG).show();
//        }
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