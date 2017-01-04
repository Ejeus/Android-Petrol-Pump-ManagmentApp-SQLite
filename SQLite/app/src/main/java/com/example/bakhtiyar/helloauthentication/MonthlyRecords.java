package com.example.bakhtiyar.helloauthentication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonthlyRecords extends Fragment {

    View view;

    long total;

    Data data;

    TextView textView;

    AlertDialog.Builder alert;

    ArrayList<Product> arrayList;

    ProductCustomAdapter productCustomAdapter;

    int num;


    ListView listView;

    Button see;


    public MonthlyRecords() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_monthly_records, container, false);

        num= BossVariable.var;

        textView = (TextView) view.findViewById(R.id.monthlytext);



        data = new Data(getContext());


        listView = (ListView) view.findViewById(R.id.monthlylist);


        arrayList = data.readProduct(num,1);

        if(arrayList==null){

            Toast.makeText(getContext(), "There is no data", Toast.LENGTH_SHORT).show();
        }
        else {


            productCustomAdapter = new ProductCustomAdapter(arrayList,getContext());

            listView.setAdapter(productCustomAdapter);

        }


        view.findViewById(R.id.totalSale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total =0;
                if(arrayList==null){

                    Toast.makeText(getContext(), "There is no Data to show", Toast.LENGTH_SHORT).show();

                }else {

                    for (int i=0; i<arrayList.size();i++){

                        total += arrayList.get(i).getSale();

                    }

                    textView.setText("Total Sale is: "+total);


                }


            }
        });

        view.findViewById(R.id.totalpurchase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                total =0;
                if(arrayList==null){

                    Toast.makeText(getContext(), "There is no Data to show", Toast.LENGTH_SHORT).show();

                }else {

                    for (int i=0; i<arrayList.size();i++){

                        total += arrayList.get(i).getPurchase();

                    }

                    textView.setText("Total Purchase is: "+total);


                }


            }
        });

        view.findViewById(R.id.totalstock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                total =0;
                if(arrayList==null){

                    Toast.makeText(getContext(), "There is no Data to show", Toast.LENGTH_SHORT).show();

                }else {

                    for (int i=0; i<arrayList.size();i++){

                        total += arrayList.get(i).getStock();

                    }

                    textView.setText("Total Stock is: "+total);


                }


            }
        });


        return view;
    }

}
