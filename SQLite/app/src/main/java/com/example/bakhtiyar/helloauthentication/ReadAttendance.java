package com.example.bakhtiyar.helloauthentication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadAttendance extends Fragment {

    CustomAttendance customAttendance;

    ListView listView;

    ArrayList<Attendance> arrayList;

    View view;


    Data data;


    public ReadAttendance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       view = inflater.inflate(R.layout.fragment_read_attendance, container, false);


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date date = new Date();

        String dttm =dateFormat.format(date);


        data = new Data(getContext());

        listView = (ListView) view.findViewById(R.id.listread);


        arrayList = data.readAttendance(dttm);

        if(arrayList == null){

            Toast.makeText(getContext(), "There is no data to show", Toast.LENGTH_SHORT).show();

        }
        else {

            customAttendance = new CustomAttendance(arrayList,getContext());

            listView.setAdapter(customAttendance);


        }


        return view;
    }

}
