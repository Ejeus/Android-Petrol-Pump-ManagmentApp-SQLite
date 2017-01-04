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
public class CustomAdapterForEvents extends BaseAdapter {

    ArrayList<Events> arrayList;
    Context context;

    TextView txtname, txtexp, txtdate;

    LayoutInflater infl;

    public CustomAdapterForEvents(ArrayList<Events> arrayList, Context context) {
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

        view = infl.from(context).inflate(R.layout.custom_event_read,viewGroup,false);

        txtname = (TextView) view.findViewById(R.id.rdeventnm);
        txtdate = (TextView) view.findViewById(R.id.rdeventdate);

        txtexp = (TextView) view.findViewById(R.id.rdevnetexp);


        txtname.setText(""+arrayList.get(i).getName());

        txtexp.setText(""+arrayList.get(i).getExpence());

        txtdate.setText(arrayList.get(i).getDate());


        return view;

    }
}
