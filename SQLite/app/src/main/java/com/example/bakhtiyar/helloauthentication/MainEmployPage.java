package com.example.bakhtiyar.helloauthentication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainEmployPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_employ_page);

        try {

            TabsPagerAdapter adp = new TabsPagerAdapter(getSupportFragmentManager());
            ViewPager pager = (ViewPager) findViewById(R.id.pager);


            // pager.setOffscreenPageLimit(0);
            pager.setAdapter(adp);
        }catch (Exception e){

            AlertDialog.Builder buld = new AlertDialog.Builder(getApplicationContext());

            buld.setMessage(""+e);

            buld.show();
            Log.d("My Tag", ""+e);
            Toast.makeText(MainEmployPage.this, ""+e, Toast.LENGTH_SHORT).show();
        }





        //pager.setOnPageChangeListener(this);
    }
}
