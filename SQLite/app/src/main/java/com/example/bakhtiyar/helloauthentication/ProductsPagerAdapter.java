package com.example.bakhtiyar.helloauthentication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Bakhtiyar on 12/1/2016.
 */
public class ProductsPagerAdapter extends FragmentPagerAdapter {
    public ProductsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position==0){

            return new PetrolFragment();
        }
        else if(position==1){

            return new DieselFragment();
        }
        else if(position==2){
            return new CngFragment();
        }else {

            return null;
        }


    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){

            return "Petrol";
        }
        else if(position==1){

            return "Diesel";
        }
        else if(position==2){
            return "CNG";
        }else {

            return null;
        }
    }
}
