package com.example.bakhtiyar.helloauthentication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewEmployRecord extends AppCompatActivity {

    Data data;

    ListView listView;

    ArrayList<EmployRead> arrayList;

    CustomEmplyAdapter custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employ_record);

        data = new Data(this);


        listView = (ListView) findViewById(R.id.employlist);

        arrayList= data.read();
        if(arrayList==null){
            Toast.makeText(this, " There is no data to show", Toast.LENGTH_SHORT).show();

        }else {

            custom = new CustomEmplyAdapter(arrayList, this);
            custom.notifyDataSetChanged();
            listView.setAdapter(custom);
        }



    }
}
