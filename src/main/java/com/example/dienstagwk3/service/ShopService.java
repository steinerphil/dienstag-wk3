package com.example.dienstagwk3.service;
import com.example.dienstagwk3.repo.*;
import com.example.dienstagwk3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void getProduct(int id){
        try {
            System.out.println(productRepo.getProduct(id).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void addOrder(int[] productToOrder){
        try {
            ProductInterface[] productsArray = new ProductInterface[productToOrder.length];
            for(int i = 0; i < productToOrder.length; i++){
                productsArray[i] = productRepo.getProduct(productToOrder[i]);
            }
            //sout for display massage from add() method in order repo
            System.out.println(orderRepo.add(productsArray));
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getOrder(int orderNumber){
        try {
            System.out.println("Order " + orderNumber + " contains " + orderRepo.getProductToOrder(orderNumber));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listOrders(){
        try {
            System.out.println(orderRepo.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
