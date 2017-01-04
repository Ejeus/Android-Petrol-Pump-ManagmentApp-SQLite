package com.example.bakhtiyar.helloauthentication;

/**
 * Created by Bakhtiyar on 12/1/2016.
 */
public class Attendance {

    String name;
    String date;
    int present, absent;

    public Attendance(String name, String date, int present, int absent) {
        this.name = name;
        this.date = date;
        this.present = present;

        this.absent = absent;
    }


    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAttendance() {

        if (present==1){

            return "Present";
        }
        else {
            return "Absent";
        }

    }
}
