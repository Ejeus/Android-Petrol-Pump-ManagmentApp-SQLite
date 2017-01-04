package com.example.bakhtiyar.helloauthentication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BossReadActivity extends AppCompatActivity {

    ViewPager viewPager;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss_read);

        try {

            BossViewFragment bossViewFragment = new BossViewFragment(getSupportFragmentManager());

            viewPager = (ViewPager) findViewById(R.id.bosspager);

            tabLayout = (TabLayout) findViewById(R.id.bosstab);


            viewPager.setAdapter(bossViewFragment);

            tabLayout.setupWithViewPager(viewPager);
        }catch (Exception e){

            Toast.makeText(BossReadActivity.this, ""+e, Toast.LENGTH_SHORT).show();

            Log.d("E", "onCreate: "+e);
        }
    }
}
