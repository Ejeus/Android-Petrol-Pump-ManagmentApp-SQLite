package com.example.bakhtiyar.helloauthentication;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class EmployAttendanceFrag extends Fragment {

    Data data,mydata;

    ListView employLists;

    View v;

    CustomEmplyAdapter custom;

    ArrayList<EmployRead> list;

    AlertDialog.Builder alert;

    public EmployAttendanceFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        v=inflater.inflate(R.layout.fragment_employ_attendance, container, false);

//        employLists = (ListView) v.findViewById(R.id.employlistatt);

        data = new Data(getContext());

        alert = new AlertDialog.Builder(getContext());

        employLists = (ListView) v.findViewById(R.id.employlistatt);

        list= data.read();
        if(list==null){
            Toast.makeText(getContext(), " There is no data to show", Toast.LENGTH_SHORT).show();

        }else {

            custom = new CustomEmplyAdapter(list, getContext());
            custom.notifyDataSetChanged();


            employLists.setAdapter(custom);





            employLists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    final int temp =i;
                    alert.setMessage("Is Employ Is Present or Not?");

                    alert.setNegativeButton("Present", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {


                            mydata = new Data(getContext());
                            String name = list.get(temp).getName();

                            //Calendar cal = Calendar.getInstance();

                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                            try {

                                Date date = new Date();

                                String dttm =dateFormat.format(date);

                                if(mydata.check(dttm,name)==1){

                                    Toast.makeText(getContext(), "Already Exsist", Toast.LENGTH_SHORT).show();
                                }else {

                                        mydata.insertAtt(name,dttm,1,0,1);

                                }

                             //   Toast.makeText(getContext(), ""+dttm, Toast.LENGTH_SHORT).show();

                            }catch (Exception e){

                                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    alert.setPositiveButton("Absent", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            mydata = new Data(getContext());
                            String name = list.get(temp).getName();

                            //Calendar cal = Calendar.getInstance();

                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                            try {

                                Date date = new Date();

                                String dttm =dateFormat.format(date);

                                if(mydata.check(dttm,name)==1){

                                    Toast.makeText(getContext(), "Already Exsist", Toast.LENGTH_SHORT).show();
                                }else {

                                    mydata.insertAtt(name,dttm,0,1,1);

                                }

                                //   Toast.makeText(getContext(), ""+dttm, Toast.LENGTH_SHORT).show();

                            }catch (Exception e){

                                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                            }






                        }
                    });

                    alert.show();
                }
            });




        }

        // Inflate the layout for this fragment
        return v;
    }



}
