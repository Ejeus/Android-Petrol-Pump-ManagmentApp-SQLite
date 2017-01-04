package com.example.bakhtiyar.helloauthentication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 11/30/2016.
 */
public class CustomEmplyAdapter extends BaseAdapter {

    ArrayList<EmployRead> list;

    Context cont;

    LayoutInflater infl;

    ImageView img;

    TextView txtname, txtphone, txtsalary,txtemail;


    public CustomEmplyAdapter(ArrayList<EmployRead> list, Context cont) {
        this.list = list;
        this.cont = cont;
    }

    @Override
    public int getCount() {
        return list.size();
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

        view = infl.from(cont).inflate(R.layout.custom_employ_list,viewGroup,false);

        txtname = (TextView) view.findViewById(R.id.readname);
        txtphone = (TextView) view.findViewById(R.id.readphone);
        txtsalary = (TextView) view.findViewById(R.id.readSalary);
        txtemail = (TextView) view.findViewById(R.id.reademail);



        img = (ImageView) view.findViewById(R.id.rdimg);

        txtname.setText(list.get(i).getName());

        txtphone.setText(list.get(i).getPhone());

        txtsalary.setText(""+list.get(i).getSalary());

        txtemail.setText(""+list.get(i).getEmail());



        if(list.get(i).getImage()==null){
            img.setImageResource(R.drawable.i);

        }else {

            Bitmap bp = BitmapFactory.decodeByteArray(list.get(i).getImage(), 0, list.get(i).image.length);


            img.setImageBitmap(bp);
        }

        return view;
    }
}
