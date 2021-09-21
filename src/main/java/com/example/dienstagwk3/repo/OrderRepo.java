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

    //methods
    @Override
    public String toString() {
        return "order= " + orders;
    }


    public String getProductToOrder(int orderNumber) {
        StringBuilder r = new StringBuilder();
        for (ProductInterface p : orders.get(orderNumber).getProduct()
        ) {
            r.append((p.getName())).append(", ");
        }
        r.delete(r.length() - 2, r.length()); //removing last comma
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
        r.delete(r.length() - 2, r.length()); // removing last comma
        r.append(" was added. Your order Number: " + orderNumber);
        return r.toString();
    }

    public List<Order> list() {
        List<Order> ordersAsList = new ArrayList<>();
        for (Integer key : orders.keySet()) {
            ordersAsList.add(orders.get(key));
        }
        return ordersAsList;
    }

}
