package com.example.bakhtiyar.helloauthentication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bakhtiyar on 12/27/2016.
 */
public class BossViewFragment extends FragmentPagerAdapter {


    public BossViewFragment(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
        if(position==0){

            return new DailyRecord();


        }
        else if(position==1){

            return new MonthlyRecords();

        }
        else {

            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){

            return "Daily Record";


        }
        else if(position==1){

            return "Monthly Records";

        }
        else {

            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
