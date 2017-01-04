package com.example.bakhtiyar.helloauthentication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetrolFragment extends Fragment {

    View v;

  double stock;

    EditText capacity, purchase, sale, price;

    Data data, mydata;

    Button submit, see, capacity_btn;

    int total_capacity;

    double purch, sle,prc, capa;

    TextView textView;

    public PetrolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v = inflater.inflate(R.layout.fragment_petrol, container, false);

        textView = (TextView) v.findViewById(R.id.petrolcapacity);

        data = new Data(getContext());


        purchase = (EditText) v.findViewById(R.id.petrolpurchase);

        sale = (EditText) v.findViewById(R.id.petrollitre);

        price = (EditText) v.findViewById(R.id.petrolprice);

        submit = (Button) v.findViewById(R.id.petrolbtn);

        see = (Button) v.findViewById(R.id.petrolsee);

        capacity_btn = (Button) v.findViewById(R.id.btnpetrolcapacity);

        capacity = (EditText) v.findViewById(R.id.capacityPetrol);

        textView.setText("Capacity "+data.checkCapacit(1));

        stock = data.stocked(1);

        Toast.makeText(getContext(), ""+stock, Toast.LENGTH_SHORT).show();

        if((total_capacity = data.checkCapacit(1))>0){
            capacity.setVisibility(View.GONE);

            capacity_btn.setVisibility(View.GONE);
        }
        else {
            purchase.setVisibility(View.GONE);
            sale.setVisibility(View.GONE);
            price.setVisibility(View.GONE);
            submit.setVisibility(View.GONE);
            see.setVisibility(View.GONE);
        }



        capacity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {

                        capa = Double.parseDouble(capacity.getText().toString());

                        Data newData = new Data(getContext());

                        newData.storeCapacity(capa,1);

                        getActivity().finish();

                        startActivity(new Intent(getContext(),MainProductPage.class));

                    }catch (Exception e){


                    }

            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = new Date();

                    String dttm =dateFormat.format(date);

                    Data pet_data;

                    pet_data = new Data(getContext());




                    if (pet_data.ReadDateProduct(dttm,1)==1){

                        Toast.makeText(getContext(), "You have already entered", Toast.LENGTH_SHORT).show();
                    }else {


                        purch = Double.parseDouble(purchase.getText().toString());
                        sle = Double.parseDouble(sale.getText().toString());
                        prc = Double.parseDouble(price.getText().toString());
                        mydata = new Data(getContext());

                        purch += stock;
                       //

                        if(purch>total_capacity ){
                            Toast.makeText(getContext(), "There is no capacity in your tank", Toast.LENGTH_SHORT).show();

                        }
                        else if(sle>purch){
                            Toast.makeText(getContext(), "There is no product to sale", Toast.LENGTH_SHORT).show();
                        }
                        else {

                                  stock = purch -sle;
                                mydata.writeProducts(purch, sle, prc,stock, dttm, 1);

                          }



                    }
                }catch (Exception e){
                    Toast.makeText(getContext(), ""+e, Toast.LENGTH_SHORT).show();

                }
            }
        });


        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(),ReadProductActivity.class);

                intent.putExtra("key",1);

                startActivity(intent);

            }
        });



        return v;
    }

}
