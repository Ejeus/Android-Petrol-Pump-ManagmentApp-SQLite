package com.example.bakhtiyar.helloauthentication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceViewFragment extends Fragment {

    ListView listView;

    Data data;

    Button search;

    EditText edttxt;

    CustomAttendance customAttendance;

    ArrayList<Attendance> arrayList;

    View v;

    public AttendanceViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v =inflater.inflate(R.layout.fragment_attendance_view, container, false);

        listView = (ListView) v.findViewById(R.id.searchlist);

        edttxt = (EditText) v.findViewById(R.id.searchedit);

        search = (Button) v.findViewById(R.id.searchbtn);

        data = new Data(getContext());


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edttxt.getText().toString().trim();

                if(TextUtils.isEmpty(name)){

                    Toast.makeText(getContext(), "Please Enter Name for search", Toast.LENGTH_SHORT).show();
                    edttxt.setText("");
                }
                else {

                    arrayList = data.search(name);

                    if(arrayList==null){
                        Toast.makeText(getContext(), "No Data to Show", Toast.LENGTH_SHORT).show();
                    }else {

                        customAttendance = new CustomAttendance(arrayList,getContext());

                        customAttendance.notifyDataSetChanged();
                        listView.setAdapter(customAttendance);

                    }



                }

            }
        });


        return v;

    }

}
