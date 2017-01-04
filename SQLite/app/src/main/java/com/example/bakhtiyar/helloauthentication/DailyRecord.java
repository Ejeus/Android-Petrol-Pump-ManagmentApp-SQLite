package com.example.bakhtiyar.helloauthentication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
public class DailyRecord extends Fragment {

    View view;

    Data data;

    AlertDialog.Builder alert;

    ArrayList<Product> arrayList;

    ProductCustomAdapter productCustomAdapter;

    int num;

    Bundle bundle;

    ListView listView;



    public DailyRecord() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daily_record, container, false);

        num= BossVariable.var;

        data = new Data(getContext());

        listView = (ListView) view.findViewById(R.id.bossreadproductlist);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date date = new Date();

        String dttm =dateFormat.format(date);

        arrayList = data.readProduct(num,dttm);

        if(arrayList==null){

            Toast.makeText(getContext(), "There is no data", Toast.LENGTH_SHORT).show();
        }
        else {


            productCustomAdapter = new ProductCustomAdapter(arrayList,getContext());

            listView.setAdapter(productCustomAdapter);

        }





        return view;
    }

}
