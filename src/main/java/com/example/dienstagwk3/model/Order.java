package com.example.dienstagwk3.model;

public class Order {

    int id;
    ProductInterface[] product;


    public Order(int id, ProductInterface[] product) {
        this.id = id;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public ProductInterface[] getProduct() {
        return product;
    }
}
