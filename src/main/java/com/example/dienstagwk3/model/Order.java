package com.example.dienstagwk3.model;

public class Order {

    int orderId;
    ProductInterface[] product;


    public Order(int orderId, ProductInterface[] product) {
        this.orderId = orderId;
        this.product = product;
    }

    public int getId() {
        return orderId;
    }

    public ProductInterface[] getProduct() {
        return product;
    }
}
