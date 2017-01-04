package com.example.bakhtiyar.helloauthentication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bakhtiyar on 11/30/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            WriteFragment writeFragment =  new WriteFragment();

            return writeFragment;

        }

        else if(position==1){
            return new ReadFragment();

        }
        else if(position==2){

            return  new EmployAttendanceFrag();
        }
        else if(position==3){

            return new ReadAttendance();

        }
        else if(position==4){

            return new AttendanceViewFragment();
        }
        else
        {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }



    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0){
            return "Write Employ Records";
        }
        else if(position==1){

            return "Read Employ Records";
        }
        else if(position==2){

            return "Employ Attendance Mark";
        }
        else if(position==3){

            return "Today Attendance";

        }
        else if(position==4){

            return "Search Attendance with name";
        }
        else {
            return null;
        }


    }
}
