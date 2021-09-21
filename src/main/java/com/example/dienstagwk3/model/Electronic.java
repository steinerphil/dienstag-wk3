package com.example.dienstagwk3.model;

public class Electronic implements ProductInterface {

    int id;
    String name;

    public Electronic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
