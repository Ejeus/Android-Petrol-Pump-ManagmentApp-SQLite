package com.example.bakhtiyar.helloauthentication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 12/1/2016.
 */
public class CustomAttendance extends BaseAdapter {

    ArrayList<Attendance> arrayList;

    Context context;

    TextView txtname, txtdate;

    LayoutInflater infl;

    public CustomAttendance(ArrayList<Attendance> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = infl.from(context).inflate(R.layout.custom_attendance,viewGroup,false);

        txtname = (TextView) view.findViewById(R.id.atname);
        txtdate = (TextView) view.findViewById(R.id.atdt);

        txtname.setText(arrayList.get(i).getName());

        txtdate.setText(arrayList.get(i).getAttendance()+"    "+arrayList.get(i).getDate());
        return view;
    }
}
