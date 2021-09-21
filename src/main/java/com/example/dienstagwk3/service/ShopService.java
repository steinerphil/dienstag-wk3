package com.example.dienstagwk3.service;
import com.example.dienstagwk3.repo.*;
import com.example.dienstagwk3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    //create order repo and product repo instance
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    @Autowired
    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public List<ProductInterface> getProduct(int id){
        ProductInterface result = null;  //TODO dies geht sauberer
        try {
         result = productRepo.getProduct(id);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return List.of(result);
    }

    public List<ProductInterface> listProducts(){

        List<ProductInterface> listOfProducts = new ArrayList<>();
        for (int i = 0; i < productRepo.list().size(); i++) {
            listOfProducts.add(productRepo.list().get(i+1));
        }
        return listOfProducts;
    }

    // add order and build product array from that
    // add th product array to orderRepo
    public String addOrder(int[] productToOrder){
            ProductInterface[] productsArray = new ProductInterface[productToOrder.length];
            for(int i = 0; i < productToOrder.length; i++){
                productsArray[i] = productRepo.getProduct(productToOrder[i]);
            }
            return orderRepo.add(productsArray);
    }

    public String getOrder(int orderNumber){
            return "Order " + orderNumber + " contains " + orderRepo.getProductToOrder(orderNumber);
    }

    public List<String> listOrders(){
            return List.of(orderRepo.list());

    }

}
