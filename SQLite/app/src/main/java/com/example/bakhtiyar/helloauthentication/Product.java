package com.example.bakhtiyar.helloauthentication;

/**
 * Created by Bakhtiyar on 12/1/2016.
 */
public class Product {

    String id;
    String name, date;

    double purchase, sale, price, stock;

    public Product(String id,String name, String date, double purchase, double sale, double price, double stock) {
        this.name = name;
        this.date = date;
        this.purchase = purchase;
        this.sale = sale;
        this.price = price;
        this.stock = stock;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getPurchase() {
        return purchase;
    }

    public double getSale() {
        return sale;
    }

    public double getPrice() {
        return price;
    }

    public double getStock() {
        return stock;
    }

    public String getId() {
        return id;
    }
}
