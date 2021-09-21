package com.example.dienstagwk3.repo;

import com.example.dienstagwk3.model.*;
import com.example.dienstagwk3.exception.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepo {


    //fields
    Map<Integer, Order> orders = new HashMap<>();
    private int orderNumber = 0;
    private final ProductRepo productRepo = new ProductRepo();

    //constructors
    public OrderRepo(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }

    public OrderRepo() {
    }

    //methods
    @Override
    public String toString() {
        return "order= " + orders;
    }

    public String getProductToOrder(int orderNumber) throws CanNotFindProduct {
        if (!orders.containsKey(orderNumber)) {
            throw new CanNotFindProduct("Error: can not find product to given order-number: " + orderNumber);
        }
        StringBuilder r = new StringBuilder();
        for (ProductInterface p : orders.get(orderNumber).getProduct()
        ) {
            r.append((p.getName())).append(", ");
        }
        r.delete(r.length()-2, r.length()); //removing last comma
        return r.toString();
    }

    public String add(ProductInterface[] productsToOrder) {
        StringBuilder r = new StringBuilder();
        orderNumber++;
        orders.put(orderNumber, new Order(orderNumber, productsToOrder));
        for (ProductInterface p : productsToOrder
        ) {
            r.append((p.getName())).append(", ");
        }
        r.delete(r.length()-2, r.length()); // removing last comma
        r.append(" was added. Your order Number: " + orderNumber);
        return r.toString();
    }

    public String list() {
        ProductInterface[] productArray = new ProductInterface[orders.size()];
        StringBuilder stringBuilder = new StringBuilder();
        if (orders.size() == 0) {
            stringBuilder.append("List is empty");
        } else {
//            StringBuilder mapAsString = new StringBuilder();
            for (Integer key : orders.keySet()) {
                stringBuilder.append("Order-ID: " + key + " = ");
                for (ProductInterface pr: orders.get(key).getProduct()) {
                    stringBuilder.append(pr.getName()).append(", ");
                }
                stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
