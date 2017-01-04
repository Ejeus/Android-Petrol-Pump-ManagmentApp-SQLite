package com.example.bakhtiyar.helloauthentication;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadFragment extends Fragment {

    Intent intent;

    ListView employList;

    View v;

    LayoutInflater infl;

    CustomEmplyAdapter custom;

    Data data;

    Data mydltdata;

    AlertDialog.Builder alert;


ArrayList<EmployRead> list;

    ViewGroup vgrp;


    public ReadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_read, container, false);

        vgrp = container;
        data = new Data(getContext());

        alert = new AlertDialog.Builder(getContext());

        employList = (ListView) v.findViewById(R.id.employlist);

        list= data.read();
        if(list==null){
            Toast.makeText(getContext(), " There is no data to show", Toast.LENGTH_SHORT).show();

        }else {

            custom = new CustomEmplyAdapter(list, getContext());
            custom.notifyDataSetChanged();


            employList.setAdapter(custom);







        }


        employList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {

                final int temp =i;
                mydltdata = new Data(getContext());

            alert.setMessage("Type you choose");

                alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        EmployTemporaryData.name = list.get(temp).getName();

                        EmployTemporaryData.fatherName = list.get(temp).getFname();

                        EmployTemporaryData.age = list.get(temp).getAge();

                        EmployTemporaryData.salary = list.get(temp).getSalary();

                        EmployTemporaryData.phone = list.get(temp).getPhone();

                        EmployTemporaryData.email = list.get(temp).getEmail();

                        intent = new Intent(getContext(),UpdateActivity.class);

                        intent.putExtra("key",list.get(temp).getId());

                        getActivity().finish();
                        startActivity(intent);

                        }
                });

                alert.setNeutralButton("SMS", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mydltdata.deleteData(list.get(temp).getId());
                        custom.notifyDataSetChanged();;
                    }
                });

                alert.show();

            }
        });









        return v;
    }

}
