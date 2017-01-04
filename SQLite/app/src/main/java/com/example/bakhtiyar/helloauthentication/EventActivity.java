package com.example.bakhtiyar.helloauthentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventActivity extends AppCompatActivity {

    EditText eventname, eventexpence, search;

    Button submit,read, update;

    ListView listView;

    ArrayList<Events> arrayList;

Data data;

    CustomAdapterForEvents customAdapterForEvents;

    String name;

    float expence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        listView = (ListView) findViewById(R.id.eventList);

        eventname = (EditText) findViewById(R.id.edevent);

        eventexpence = (EditText) findViewById(R.id.edexpence);

        submit = (Button) findViewById(R.id.eventsubmit);

        read = (Button) findViewById(R.id.eventRead);

        data = new Data(this);

        arrayList = data.readEvents();

        search = (EditText) findViewById(R.id.searchevent);

        // update = (Button) findViewById(R.id.eventupdate);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    name = eventname.getText().toString().trim();

                    expence = Float.parseFloat(eventexpence.getText().toString());


                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = new Date();

                    String dttm =dateFormat.format(date);

                    data.insertEvents(name,dttm,expence);

                    eventname.setText("");
                    eventexpence.setText("");


                }catch (Exception e){

                    Toast.makeText(EventActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                }

            }
        });



        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayList = data.readEvents();

                if(arrayList==null){

                    Toast.makeText(EventActivity.this, "There is no data to show", Toast.LENGTH_SHORT).show();
                }else {

                    customAdapterForEvents = new CustomAdapterForEvents(arrayList,getApplicationContext());
                    listView.setAdapter(customAdapterForEvents);

                }

            }
        });


        findViewById(R.id.eventbtnsearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String key = search.getText().toString().trim();

                if(TextUtils.isEmpty(key)){
                    Toast.makeText(EventActivity.this, "Please Enter Event Name for Search", Toast.LENGTH_SHORT).show();

                }
                else {

                    arrayList = data.searchEvent(key);

                    if(arrayList==null){

                        Toast.makeText(EventActivity.this, "There is no data to show", Toast.LENGTH_SHORT).show();
                    }else {

                        customAdapterForEvents = new CustomAdapterForEvents(arrayList,getApplicationContext());
                        listView.setAdapter(customAdapterForEvents);

                    }




                }

            }
        });


    }
}
