package com.example.bakhtiyar.helloauthentication;

/**
 * Created by Bakhtiyar on 11/30/2016.
 */
public class EmployRead {
    String name, fname, phone, email;
    int age;
    float salary;
    String id;
    public  byte[] image;

    public EmployRead(String name, String fname, String phone, String email, int age, float salary, byte[] image, String id) {
        this.name = name;
        this.fname = fname;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.image = image;
        this.id =id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public byte[] getImage() {
        return image;
    }
}
