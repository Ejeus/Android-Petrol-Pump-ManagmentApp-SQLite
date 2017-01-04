package com.example.bakhtiyar.helloauthentication;

import android.provider.BaseColumns;

/**
 * Created by Bakhtiyar on 11/30/2016.
 */
public class Employ {

    public static final String DB_NAME = "Data.db";

    public static String employtableName;

    public static String employAttentdancetable;

    public static String petrolRecord;

    public static String dieselRecord;

    public static String cngRecord;



    //////////////For Events//////////////////////////
    public static final class EVENT implements BaseColumns{


        public static final String _ID ="_ID";

        public static final String EVENT_NAME="EVENT_NAME";

        public static final String DATE ="DATE";

        public static final String EXPENCE ="EXPENCE";


    }










    ///////////////About products///////////////////////

    public static final class PRODUCT_SCHEME implements BaseColumns{

        public static final String _ID = "_ID";

        public static final String DATE = "DATE";

        public static final String PURCHASED = "PURCHASED";

        public static final String STOCK = "STOCK";

        public static final String SALE = "SALE";

        public static final String LITRE_PRICE= "LITRE_PRICE";

               
    }




    ///////////// About Attendance///////////////////////
    public static final class EmployAttendance implements BaseColumns{

        public static final String _ID ="_id";

        public static final String present = "Present";
        public static final String Absent = "Absent";
        public static final String Name = "NAME";
        public static final String Date = "Date";
        public static final String FLAG ="flag";
    }





/////////////// About Employ////////////////////////////////////
    public static final class EmployRecord implements BaseColumns {



        public static final String _ID = "_ID";

        public static final String NAME = "NAME";

        public static final String FATHER_NAME = "FATHER_NAME";

        public static final String PHONE = "PHONE";

        public static final String EMAIL = "EMAIL";

        public static final String SALARY = "SALARY";

        public static final String IMAGE = "IMAGE";

        public static final String AGE = "AGE";
    }

    public final class CapacityOfTank implements BaseColumns{


        public static final String _ID = "_ID";

        public static final String PRODUCT_NAME = "PRODUCT";

        public static final String CAPACITY = "CAPACITY";

    }

}
