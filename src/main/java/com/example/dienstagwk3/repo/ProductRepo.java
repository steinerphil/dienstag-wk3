package com.example.dienstagwk3.repo;

import java.util.*;
import com.example.dienstagwk3.model.*;
import com.example.dienstagwk3.exception.*;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {

    //direct instantiating products map with implementations of Products
    private final Map<Integer, ProductInterface> products = new HashMap<>((Map.ofEntries(
            Map.entry(10, new Grocery(10, "Milk")),
            Map.entry(20, new Grocery(20, "Beer")),
            Map.entry(30, new Electronic(30, "Computer")),
            Map.entry(40, new Electronic(40, "Smartphone"))
    )));

    //empty constructor
    public ProductRepo(){}


    public String list() {
        String r = "";
        if(products.size() == 0){
            r = "Product Repo is empty";
        } else {
            StringBuilder mapAsString = new StringBuilder();
            for (Integer key : products.keySet()) {
                mapAsString.append("ID: " + key + " = " + products.get(key).getName() + "\n");
            }
            r = mapAsString.toString();
        }
        return r;
    }

    public ProductInterface getProduct(int id) throws CanNotFindProduct {
        if(!products.containsKey(id)){
            throw new CanNotFindProduct("The product does not exist. Product id: " + id);
        }
        return products.get(id);
    }


}
