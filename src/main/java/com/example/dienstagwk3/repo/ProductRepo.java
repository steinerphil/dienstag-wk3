package com.example.dienstagwk3.repo;

import java.util.*;
import com.example.dienstagwk3.model.*;
import com.example.dienstagwk3.exception.*;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {

    //direct instantiating products map with implementations of Products
    private final Map<Integer, ProductInterface> products = new HashMap<>((Map.ofEntries(
            Map.entry(1, new Grocery(1, "Milk")),
            Map.entry(2, new Grocery(2, "Beer")),
            Map.entry(3, new Electronic(3, "Computer")),
            Map.entry(4, new Electronic(4, "Smartphone"))
    )));

    //empty constructor
    public ProductRepo(){}


    public Map<Integer, ProductInterface> list() {
       return products;
    }

    public ProductInterface getProduct(int id) {
        return (products.get(id));
    }


}
