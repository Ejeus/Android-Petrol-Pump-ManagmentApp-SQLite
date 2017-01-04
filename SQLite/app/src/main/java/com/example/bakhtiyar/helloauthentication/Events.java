package com.example.bakhtiyar.helloauthentication;

/**
 * Created by Bakhtiyar on 12/1/2016.
 */
public class Events {

    String name, date,id;

    float expence;

    public Events(String name, String date, String id, float expence) {
        this.name = name;
        this.date = date;
        this.id = id;
        this.expence = expence;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public float getExpence() {
        return expence;
    }
}
