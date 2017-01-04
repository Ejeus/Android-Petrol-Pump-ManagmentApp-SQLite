package com.example.bakhtiyar.helloauthentication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainProductPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product_page);
        try {

            ProductsPagerAdapter adp = new ProductsPagerAdapter(getSupportFragmentManager());
            ViewPager pager = (ViewPager) findViewById(R.id.vpager);


            // pager.setOffscreenPageLimit(0);
            pager.setAdapter(adp);
        }catch (Exception e){

            AlertDialog.Builder buld = new AlertDialog.Builder(getApplicationContext());

            buld.setMessage(""+e);

            buld.show();
            Log.d("My Tag", ""+e);
            Toast.makeText(MainProductPage.this, ""+e, Toast.LENGTH_SHORT).show();
        }



    }
}
