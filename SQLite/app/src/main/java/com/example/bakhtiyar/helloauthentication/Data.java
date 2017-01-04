package com.example.bakhtiyar.helloauthentication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Bakhtiyar on 11/30/2016.
 */
public class Data extends SQLiteOpenHelper {


    ArrayList<EmployRead> list;

    ContentValues contentValues;

    SQLiteDatabase sqLiteDatabase;

    Cursor cursor;

    Context context;

    public static final String tableName = "Employ";


    public static final String AttendanceTable = "Attendance";


    public static final String EVENT_TABLE = "EVENT_TABLE";

    public static final String PETROL_TABLE = "Petrol";

    public static final String DIESEL_TABLE = "Diesel";

    public static final String CNG_TABLE = "Cng";

    public static final String TANK_CAPACITY = "TANK_CAPACITY";

    public static final String createEventTable = "CREATE TABLE IF NOT EXISTS " + EVENT_TABLE + "("
            + Employ.EVENT._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + Employ.EVENT.EVENT_NAME + " TEXT ," + Employ.EVENT.DATE + " TEXT, "
            + Employ.EVENT.EXPENCE + " REAL)";


    public static final String createTablePetrol = "CREATE TABLE IF NOT EXISTS " + PETROL_TABLE + " ("
            + Employ.PRODUCT_SCHEME._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + Employ.PRODUCT_SCHEME.PURCHASED + " REAL ,"
            + Employ.PRODUCT_SCHEME.SALE + " REAL ,"
            + Employ.PRODUCT_SCHEME.LITRE_PRICE + " REAL,"
            + Employ.PRODUCT_SCHEME.STOCK + " REAL,"
            + Employ.PRODUCT_SCHEME.DATE + " TEXT)";


    public static final String createTableDiesel = "CREATE TABLE IF NOT EXISTS " + DIESEL_TABLE + " ("
            + Employ.PRODUCT_SCHEME._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + Employ.PRODUCT_SCHEME.PURCHASED + " REAL ,"
            + Employ.PRODUCT_SCHEME.SALE + " REAL ,"
            + Employ.PRODUCT_SCHEME.LITRE_PRICE + " REAL,"
            + Employ.PRODUCT_SCHEME.STOCK + " REAL,"
            + Employ.PRODUCT_SCHEME.DATE + " TEXT)";


    public static final String createTableCng = "CREATE TABLE IF NOT EXISTS " + CNG_TABLE + " ("
            + Employ.PRODUCT_SCHEME._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + Employ.PRODUCT_SCHEME.PURCHASED + " REAL ,"
            + Employ.PRODUCT_SCHEME.SALE + " REAL ,"
            + Employ.PRODUCT_SCHEME.LITRE_PRICE + " REAL ,"
            + Employ.PRODUCT_SCHEME.STOCK + " REAL ,"
            + Employ.PRODUCT_SCHEME.DATE + " TEXT)";


    public static final String createAttendanceTable =
            "CREATE TABLE IF NOT EXISTS " + AttendanceTable + "("
                    + Employ.EmployAttendance._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + Employ.EmployAttendance.Name + " TEXT NOT NULL , "
                    + Employ.EmployAttendance.present + " INTEGER ,"
                    + Employ.EmployAttendance.Absent + " INTEGER ,"
                    + Employ.EmployAttendance.Date + " TEXT , "
                    + Employ.EmployAttendance.FLAG + " INTEGER)";


    public static final String createEmployTable =
            "CREATE TABLE IF NOT EXISTS " + tableName + "("
                    + Employ.EmployRecord._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Employ.EmployRecord.NAME + " TEXT NOT NULL, "
                    + Employ.EmployRecord.FATHER_NAME + " TEXT NOT NULL,"
                    + Employ.EmployRecord.AGE + " INTEGER,"
                    + Employ.EmployRecord.SALARY + " REAL,"
                    + Employ.EmployRecord.EMAIL + " TEXT,"
                    + Employ.EmployRecord.PHONE + " TEXT," + Employ.EmployRecord.IMAGE + " BLOB )";

    public static final String CREATE_TABLE_TANK_CAPACITY =
            "CREATE TABLE IF NOT EXISTS "+ TANK_CAPACITY +"("
            +Employ.CapacityOfTank._ID +" INTEGER PRIMARY KEY AUTOINCREMENT ,"
            +Employ.CapacityOfTank.PRODUCT_NAME+" TEXT ,"
            +Employ.CapacityOfTank.CAPACITY +" REAL)";

    public Data(Context context) {
        super(context, Employ.DB_NAME, null, 7);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(createEmployTable);

        sqLiteDatabase.execSQL(createAttendanceTable);

        sqLiteDatabase.execSQL(createTablePetrol);

        sqLiteDatabase.execSQL(createTableDiesel);

        sqLiteDatabase.execSQL(createTableCng);

        sqLiteDatabase.execSQL(createEventTable);

        sqLiteDatabase.execSQL(CREATE_TABLE_TANK_CAPACITY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AttendanceTable);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PETROL_TABLE);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DIESEL_TABLE);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CNG_TABLE);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EVENT_TABLE);

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+CREATE_TABLE_TANK_CAPACITY);

        onCreate(sqLiteDatabase);

    }


    //////////////For Employ Entry///////////////////////////////


    public boolean writeEmployData(String name, String fname, String email, String phone, int age, float salary, byte[] image) {
        sqLiteDatabase = this.getWritableDatabase();
        //onCreate(sqLiteDatabase);
        contentValues = new ContentValues();

        contentValues.put(Employ.EmployRecord.NAME, name);
        contentValues.put(Employ.EmployRecord.FATHER_NAME, fname);
        contentValues.put(Employ.EmployRecord.EMAIL, email);
        contentValues.put(Employ.EmployRecord.PHONE, phone);
        contentValues.put(Employ.EmployRecord.AGE, age);
        contentValues.put(Employ.EmployRecord.SALARY, salary);

        contentValues.put(Employ.EmployRecord.IMAGE, image);


        long flag = sqLiteDatabase.insert(tableName, null, contentValues);

        if (flag == -1) {
            return false;

        } else {

            return true;
        }


    }

    public ArrayList<EmployRead> read() {
        list = new ArrayList<>();

        int count = 0;


        try {


            sqLiteDatabase = this.getReadableDatabase();
            //onCreate(sqLiteDatabase);
            cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + tableName, null);
            while (cursor.moveToNext()) {
                count++;

                String id = cursor.getString(cursor.getColumnIndex(Employ.EmployRecord._ID));
                String name = cursor.getString(cursor.getColumnIndex(Employ.EmployRecord.NAME));
                String fname = cursor.getString(cursor.getColumnIndex(Employ.EmployRecord.FATHER_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(Employ.EmployRecord.AGE));
                String phone = cursor.getString(cursor.getColumnIndex(Employ.EmployRecord.PHONE));
                float salary = cursor.getFloat(cursor.getColumnIndex(Employ.EmployRecord.SALARY));
                String email = cursor.getString(cursor.getColumnIndex(Employ.EmployRecord.EMAIL));

                byte[] b = cursor.getBlob(cursor.getColumnIndex(Employ.EmployRecord.IMAGE));
                list.add(new EmployRead(name, fname, phone, email, age, salary, b, id));

            }
        } catch (Exception e) {
            Log.d("Read", "read: " + e);
            Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
        }

        if (count == 0) {
            cursorClose();
            return null;
        }

        cursorClose();

        return list;
    }


    public void deleteData(String id) {
        sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL("DELETE FROM " + tableName + " WHERE _ID = " + id);
        Toast.makeText(context, "DELETED", Toast.LENGTH_SHORT).show();
    }


    public void updateRecord(String value, int count, String id) {
        sqLiteDatabase = this.getWritableDatabase();

        contentValues = new ContentValues();

        if (count == 1) {

            contentValues.put(Employ.EmployRecord.NAME, value);

            sqLiteDatabase.update(tableName, contentValues, Employ.EmployRecord._ID +" = "+ id, null);


        } else if (count == 2) {

            contentValues.put(Employ.EmployRecord.FATHER_NAME, value);

            sqLiteDatabase.update(tableName, contentValues, Employ.EmployRecord._ID +" = "+ id, null);


        } else if (count == 3) {

            contentValues.put(Employ.EmployRecord.PHONE, value);

            sqLiteDatabase.update(tableName, contentValues, Employ.EmployRecord._ID +" = "+ id, null);


        } else if (count == 4) {

            contentValues.put(Employ.EmployRecord.EMAIL, value);

            sqLiteDatabase.update(tableName, contentValues, Employ.EmployRecord._ID +" = "+ id, null);


        }


    }

    public void updateRecord(float salary, String id) {

        sqLiteDatabase = this.getWritableDatabase();

        contentValues = new ContentValues();

        contentValues.put(Employ.EmployRecord.SALARY, salary);

        sqLiteDatabase.update(tableName, contentValues, Employ.EmployRecord._ID +" = "+ id, null);

    }

    public void updateRecord(int age, String id) {

        sqLiteDatabase = this.getWritableDatabase();

        contentValues = new ContentValues();

        contentValues.put(Employ.EmployRecord.AGE, age);

        sqLiteDatabase.update(tableName, contentValues, Employ.EmployRecord._ID +" = "+ id, null);

    }

    public void updateRecord(byte[] value, String id) {

        sqLiteDatabase = this.getWritableDatabase();

        contentValues = new ContentValues();

        contentValues.put(Employ.EmployRecord.IMAGE, value);

        sqLiteDatabase.update(tableName, contentValues, Employ.EmployRecord._ID +" = "+ id, null);

    }

//////////////////////////////For Employ Attendance////////////////////////////////////


    public int check(String date, String name) {

        int checked;
        sqLiteDatabase = this.getReadableDatabase();

        try {


            cursor = sqLiteDatabase.rawQuery("SELECT " + Employ.EmployAttendance.FLAG + " FROM "
                    + AttendanceTable + " WHERE " + Employ.EmployAttendance.Date + " = '" + date + "' AND "
                    + Employ.EmployAttendance.Name + " = '" + name + "'", null);

            while (cursor.moveToNext()) {
                checked = cursor.getInt(cursor.getColumnIndex(Employ.EmployAttendance.FLAG));

                cursorClose();
                return 1;

            }
        } catch (Exception e) {
            Log.d("Reading", "" + e);

        }
        return 0;
    }


    public void insertAtt(String name, String date, int present, int absent, int flag) {
        sqLiteDatabase = this.getWritableDatabase();

        contentValues = new ContentValues();

        contentValues.put(Employ.EmployAttendance.Name, name);
        contentValues.put(Employ.EmployAttendance.Date, date);
        contentValues.put(Employ.EmployAttendance.present, present);
        contentValues.put(Employ.EmployAttendance.Absent, absent);
        contentValues.put(Employ.EmployAttendance.FLAG, flag);

        long l = sqLiteDatabase.insert(AttendanceTable, null, contentValues);

        if (l == -1) {
            Toast.makeText(context, "Not Inserted", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();
        }

    }


    public ArrayList<Attendance> search(String name) {
        ArrayList<Attendance> arrayList;

        int count = 0;

        arrayList = new ArrayList<>();

        sqLiteDatabase = this.getReadableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + AttendanceTable + " WHERE "
                + Employ.EmployAttendance.Name + " = '" + name + "'", null);

        while (cursor.moveToNext()) {

            count++;
            String ename = cursor.getString(cursor.getColumnIndex(Employ.EmployAttendance.Name));

            String date = cursor.getString(cursor.getColumnIndex(Employ.EmployAttendance.Date));

            int peresent = cursor.getInt(cursor.getColumnIndex(Employ.EmployAttendance.present));

            int absent = cursor.getInt(cursor.getColumnIndex(Employ.EmployAttendance.Absent));

            arrayList.add(new Attendance(ename, date, peresent, absent));

        }

        if (count == 0) {

            cursorClose();
            return null;
        }
        cursorClose();

        return arrayList;

    }


    public ArrayList<Attendance> readAttendance(String date){
        sqLiteDatabase = this.getReadableDatabase();

        ArrayList<Attendance> arrayList = new ArrayList<>();

        int i=0;


        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + AttendanceTable + " WHERE "
                + Employ.EmployAttendance.Date + " = '" + date + "'", null);


        while (cursor.moveToNext()){

            String name = cursor.getString(cursor.getColumnIndex(Employ.EmployAttendance.Name));

            String datee = cursor.getString(cursor.getColumnIndex(Employ.EmployAttendance.Date));

            int present = cursor.getInt(cursor.getColumnIndex(Employ.EmployAttendance.present));

            int absent = cursor.getInt(cursor.getColumnIndex(Employ.EmployAttendance.Absent));

            Attendance attendance = new Attendance(name,datee,present,absent);

            arrayList.add(attendance);

            i++;

        }

        if(i==0){

            return null;

        }

        return arrayList;


    }


    ////////////////////////////// About Capacities///////////////////////////////////


    public int checkCapacit(int check) {
        sqLiteDatabase = this.getReadableDatabase();
        int value = 0;


        if (check == 1) {
            cursor = sqLiteDatabase.rawQuery("SELECT " + Employ.CapacityOfTank.CAPACITY + " FROM "
                    + TANK_CAPACITY + " WHERE "+ Employ.CapacityOfTank.PRODUCT_NAME +" = 'Petrol'", null);
            while (cursor.moveToFirst()) {
                value = cursor.getInt(cursor.getColumnIndex(Employ.CapacityOfTank.CAPACITY));
                cursorClose();
                return value;
            }
        } else if (check == 2) {
            cursor = sqLiteDatabase.rawQuery("SELECT " + Employ.CapacityOfTank.CAPACITY + " FROM "
                    + TANK_CAPACITY + " WHERE "+ Employ.CapacityOfTank.PRODUCT_NAME +" = 'Diesel'", null);
            while (cursor.moveToFirst()) {
                value = cursor.getInt(cursor.getColumnIndex(Employ.CapacityOfTank.CAPACITY));
                cursorClose();
                return value;
            }

        } else if (check == 3) {
            cursor = sqLiteDatabase.rawQuery("SELECT " + Employ.CapacityOfTank.CAPACITY + " FROM "
                    + TANK_CAPACITY + " WHERE "+ Employ.CapacityOfTank.PRODUCT_NAME +" = 'CNG'", null);
            while (cursor.moveToFirst()) {
                value = cursor.getInt(cursor.getColumnIndex(Employ.CapacityOfTank.CAPACITY));
                cursorClose();
                return value;
            }

        }

            return value;


    }

    public void storeCapacity(double capacity, int number){

        sqLiteDatabase = this.getWritableDatabase();

        contentValues = new ContentValues();

        if(number ==1){

            contentValues.put(Employ.CapacityOfTank.PRODUCT_NAME, "Petrol");

            contentValues.put(Employ.CapacityOfTank.CAPACITY, capacity);

         long l  =  sqLiteDatabase.insert(TANK_CAPACITY,null,contentValues);

            if(l==-1){

                Toast.makeText(context, "Not inserted", Toast.LENGTH_SHORT).show();

            }
            else {

                Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();

            }


        }else if(number == 2){

            contentValues.put(Employ.CapacityOfTank.PRODUCT_NAME, "Diesel");

            contentValues.put(Employ.CapacityOfTank.CAPACITY, capacity);

            long l  =  sqLiteDatabase.insert(TANK_CAPACITY,null,contentValues);

            if(l==-1){

                Toast.makeText(context, "Not inserted", Toast.LENGTH_SHORT).show();

            }
            else {

                Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();

            }




        }else if(number == 3){

            contentValues.put(Employ.CapacityOfTank.PRODUCT_NAME, "CNG");

            contentValues.put(Employ.CapacityOfTank.CAPACITY, capacity);

            long l  =  sqLiteDatabase.insert(TANK_CAPACITY,null,contentValues);

            if(l==-1){

                Toast.makeText(context, "Not inserted", Toast.LENGTH_SHORT).show();

            }
            else {

                Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();

            }

        }


    }





///////////////////////////////////////For Product Read////////////////////////////
    public int ReadDateProduct(String date, int check){
        sqLiteDatabase = this.getReadableDatabase();


        if (check==1){
            cursor = sqLiteDatabase.rawQuery("SELECT "+ Employ.PRODUCT_SCHEME.DATE+" FROM "+PETROL_TABLE+" WHERE "
                    +Employ.PRODUCT_SCHEME.DATE+" = '"+date+"' ",null);

            while (cursor.moveToNext()){

                cursorClose();
                return 1;

            }

        }

        if (check==2){
            cursor = sqLiteDatabase.rawQuery("SELECT "+ Employ.PRODUCT_SCHEME.DATE+" FROM "+DIESEL_TABLE+" WHERE "
                    +Employ.PRODUCT_SCHEME.DATE+" = '"+date+"' ",null);

            while (cursor.moveToNext()){

                cursorClose();
                return 1;

            }

        }

        if (check==3){
            cursor = sqLiteDatabase.rawQuery("SELECT "+ Employ.PRODUCT_SCHEME.DATE+" FROM "+CNG_TABLE+" WHERE "
                    +Employ.PRODUCT_SCHEME.DATE+" = '"+date+"' ",null);

            while (cursor.moveToNext()){

                cursorClose();
                return 1;

            }

        }



        return 0;


    }

    public void writeProducts(double purchase, double sale, double litre, double stock,String date, int check){
            try {


                    sqLiteDatabase = this.getWritableDatabase();

                    contentValues = new ContentValues();

                    long l;



                Toast.makeText(context, "purchase "+purchase + "Sale "+ sale+" Stock "+stock, Toast.LENGTH_SHORT).show();

                    if (check ==1){

                        contentValues.put(Employ.PRODUCT_SCHEME.PURCHASED,purchase);

                        contentValues.put(Employ.PRODUCT_SCHEME.SALE,sale);

                        contentValues.put(Employ.PRODUCT_SCHEME.LITRE_PRICE,litre);

                        contentValues.put(Employ.PRODUCT_SCHEME.STOCK,stock);

                        contentValues.put(Employ.PRODUCT_SCHEME.DATE,date);

                      l =  sqLiteDatabase.insert(PETROL_TABLE,null,contentValues);

                        if(l==-1){

                            Toast.makeText(context, "Not Inserted", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else if(check==2){

                        contentValues.put(Employ.PRODUCT_SCHEME.PURCHASED,purchase);

                        contentValues.put(Employ.PRODUCT_SCHEME.SALE,sale);

                        contentValues.put(Employ.PRODUCT_SCHEME.LITRE_PRICE,litre);

                        contentValues.put(Employ.PRODUCT_SCHEME.STOCK,stock);

                        contentValues.put(Employ.PRODUCT_SCHEME.DATE,date);
                       l=  sqLiteDatabase.insert(DIESEL_TABLE,null,contentValues);

                        if(l==-1){

                            Toast.makeText(context, "Not Inserted", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();
                        }

                    }

                    else if(check==3){
                        contentValues.put(Employ.PRODUCT_SCHEME.PURCHASED,purchase);
                        contentValues.put(Employ.PRODUCT_SCHEME.SALE,sale);

                        contentValues.put(Employ.PRODUCT_SCHEME.LITRE_PRICE,litre);

                        contentValues.put(Employ.PRODUCT_SCHEME.STOCK,stock);

                        contentValues.put(Employ.PRODUCT_SCHEME.DATE,date);

                       l= sqLiteDatabase.insert(CNG_TABLE,null,contentValues);


                        if(l==-1){

                            Toast.makeText(context, "Not Inserted", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();
                        }
                    }

            }catch (Exception e){

                Log.d("Write", ""+e);

                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }

    }

    public double stocked(int check){

        sqLiteDatabase = this.getReadableDatabase();

        double stock=0;

        if(check == 1){

            cursor = sqLiteDatabase.rawQuery("SELECT "+ Employ.PRODUCT_SCHEME.STOCK+" FROM "+PETROL_TABLE,null);

            while (cursor.moveToNext()){

                stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));

            }

            cursorClose();

        }else if(check == 2){

            cursor = sqLiteDatabase.rawQuery("SELECT "+ Employ.PRODUCT_SCHEME.STOCK+" FROM "+DIESEL_TABLE,null);

            while (cursor.moveToNext()){

                stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));

            }

            cursorClose();



        }else if(check == 3){
            cursor = sqLiteDatabase.rawQuery("SELECT "+ Employ.PRODUCT_SCHEME.STOCK+" FROM "+CNG_TABLE,null);

            while (cursor.moveToNext()){

                stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));

            }

            cursorClose();

        }


        return stock;

    }

    public ArrayList<Product> readProduct(int pos){
            ArrayList<Product> arrayList;
        int count =0;

        arrayList = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();

        if(pos==1){

            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+PETROL_TABLE,null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"Petrol",date,purchase,sale,price,stock));

            }


        }else if(pos==2){


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+DIESEL_TABLE,null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"Diesel",date,purchase,sale,price,stock));

            }


        }else if(pos==3){


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+CNG_TABLE,null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"CNG",date,purchase,sale,price,stock));

            }
        }



        if(count==0){

            cursorClose();
            return null;
        }
        cursorClose();

        return arrayList;
    }

    /////////////////////////////////

    public ArrayList<Product> readProduct(int pos,String dttm){
        ArrayList<Product> arrayList;
        int count =0;

        arrayList = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();

        if(pos==1){

            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+PETROL_TABLE+" WHERE "+Employ.PRODUCT_SCHEME.DATE+" = '"+dttm+"'",null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"Petrol",date,purchase,sale,price,stock));

            }


        }else if(pos==2){


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+DIESEL_TABLE+" WHERE "+Employ.PRODUCT_SCHEME.DATE+" = '"+dttm+"'",null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"Diesel",date,purchase,sale,price,stock));

            }


        }else if(pos==3){


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+CNG_TABLE+" WHERE "+Employ.PRODUCT_SCHEME.DATE+" = '"+dttm+"'",null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"CNG",date,purchase,sale,price,stock));

            }
        }



        if(count==0){

            cursorClose();
            return null;
        }
        cursorClose();

        return arrayList;
    }
    /////////////////////////////////

    public ArrayList<Product> readProduct(int pos,int i){
        ArrayList<Product> arrayList;
        int count =0;

        arrayList = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();

        if(pos==1){

            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+PETROL_TABLE+" WHERE "+Employ.PRODUCT_SCHEME.DATE+" BETWEEN '01-12-2016' AND '31-12-2016'",null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"Petrol",date,purchase,sale,price,stock));

            }


        }else if(pos==2){


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+DIESEL_TABLE+" WHERE "+Employ.PRODUCT_SCHEME.DATE+" BETWEEN '01-12-2016' AND '31-12-2016'",null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"Diesel",date,purchase,sale,price,stock));

            }


        }else if(pos==3){


            cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+CNG_TABLE+" WHERE "+Employ.PRODUCT_SCHEME.DATE+" BETWEEN '01-12-2016' AND '31-12-2016'",null);

            while (cursor.moveToNext()){

                count ++;
                String id = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME._ID));
                String date = cursor.getString(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.DATE));

                double stock = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.STOCK));
                double purchase = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.PURCHASED));
                double price = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.LITRE_PRICE));
                double sale = cursor.getDouble(cursor.getColumnIndex(Employ.PRODUCT_SCHEME.SALE));

                arrayList.add(new Product(id,"CNG",date,purchase,sale,price,stock));

            }
        }



        if(count==0){

            cursorClose();
            return null;
        }
        cursorClose();

        return arrayList;
    }




    ///////////////////////////////////








    public void deleteProduct(String id, int pos){

        if(pos==1){

            sqLiteDatabase.execSQL("DELETE FROM "+PETROL_TABLE+" WHERE "+ Employ.PRODUCT_SCHEME._ID+" = '"+id+"'");

        }else if(pos==2){
            sqLiteDatabase.execSQL("DELETE FROM "+DIESEL_TABLE+" WHERE "+ Employ.PRODUCT_SCHEME._ID+" = '"+id+"'");

        }else if(pos==3){
            sqLiteDatabase.execSQL("DELETE FROM "+CNG_TABLE+" WHERE "+ Employ.PRODUCT_SCHEME._ID+" = '"+id+"'");

        }


    }

    ////////////////////////////////About Events//////////


    public void insertEvents(String name, String date, Float expence){

        sqLiteDatabase = this.getWritableDatabase();

        contentValues = new ContentValues();

        contentValues.put(Employ.EVENT.EVENT_NAME,name);

        contentValues.put(Employ.EVENT.DATE,date);

        contentValues.put(Employ.EVENT.EXPENCE,expence);

        long l = sqLiteDatabase.insert(EVENT_TABLE,null,contentValues);

        if(l==-1){
            Toast.makeText(context, "Not Inserted", Toast.LENGTH_SHORT).show();

        }else {

            Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show();
        }


    }


    public ArrayList<Events> readEvents(){

        int count =0;
        ArrayList<Events> arrayList;

        arrayList = new ArrayList<>();

        sqLiteDatabase = this.getReadableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+EVENT_TABLE,null);

        while (cursor.moveToNext()){
            count++;

            String id = cursor.getString(cursor.getColumnIndex(Employ.EVENT._ID));

            String name = cursor.getString(cursor.getColumnIndex(Employ.EVENT.EVENT_NAME));

            String date = cursor.getString(cursor.getColumnIndex(Employ.EVENT.DATE));

            float expence = cursor.getFloat(cursor.getColumnIndex(Employ.EVENT.EXPENCE));

            arrayList.add(new Events(name,date,id,expence));

        }
        if(count==0){
            cursorClose();
            return null;

        }

        cursorClose();
        return arrayList;

    }


    public ArrayList<Events> searchEvent(String name){


        int count =0;
        ArrayList<Events> arrayList;

        arrayList = new ArrayList<>();

        sqLiteDatabase = this.getReadableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+EVENT_TABLE+" WHERE "+ Employ.EVENT.EVENT_NAME+" = '"+name+"'",null);

        while (cursor.moveToNext()){
            count++;

            String id = cursor.getString(cursor.getColumnIndex(Employ.EVENT._ID));

            String ename = cursor.getString(cursor.getColumnIndex(Employ.EVENT.EVENT_NAME));

            String date = cursor.getString(cursor.getColumnIndex(Employ.EVENT.DATE));

            float expence = cursor.getFloat(cursor.getColumnIndex(Employ.EVENT.EXPENCE));

            arrayList.add(new Events(ename,date,id,expence));

        }
        if(count==0){

            cursorClose();
            return null;


        }
        cursorClose();

        return arrayList;

    }

    public void cursorClose(){
        cursor.close();

    }

}
