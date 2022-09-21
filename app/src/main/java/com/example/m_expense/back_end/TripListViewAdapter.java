package com.example.m_expense.back_end;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.m_expense.R;

import java.util.ArrayList;
import java.util.List;

public class TripListViewAdapter extends BaseAdapter {

    List<Trip> tripList = new ArrayList<>();

    public TripListViewAdapter(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public int getCount() {
        return tripList.size();
    }

    @Override
    public Object getItem(int i) {
        return tripList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewTrip;
        if (view == null) {
            viewTrip = View.inflate(viewGroup.getContext(), R.layout.fragment_trip_block, null);
        } else viewTrip = view;

        //Bind sữ liệu phần tử vào View
        Trip trip = (Trip) getItem(i);
//        ((TextView) viewTrip.findViewById(R.id.idproduct)).setText(String.format("ID = %d", product.productID));
//        ((TextView) viewTrip.findViewById(R.id.nameproduct)).setText(String.format("Tên SP : %s", product.name));
//        ((TextView) viewTrip.findViewById(R.id.priceproduct)).setText(String.format("Giá %d", product.price));
        ((TextView) viewTrip.findViewById(R.id.name)).setText(trip.getName());
        ((TextView) viewTrip.findViewById(R.id.fromDate)).setText(trip.getStartDate());
        ((TextView) viewTrip.findViewById(R.id.toDate)).setText(trip.getEndDate());
        ((TextView) viewTrip.findViewById(R.id.start_destination)).setText(trip.getStartDestination());
        ((TextView) viewTrip.findViewById(R.id.end_destination)).setText(trip.getEndDestination());
        ((TextView) viewTrip.findViewById(R.id.amount)).setText(String.valueOf(trip.getAmount()));


        return viewTrip;
    }
}
