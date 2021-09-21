package com.example.dienstagwk3.controller;

import com.example.dienstagwk3.model.Order;
import com.example.dienstagwk3.model.ProductInterface;
import com.example.dienstagwk3.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("shop")
public class ProductController {

    private final ShopService shopService;

    @Autowired
    public ProductController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<ProductInterface> getProduct(@RequestParam Optional<Integer> id){
        if(id.isPresent()) {
            return shopService.getProduct(id.get());
        }
      return  shopService.listProducts();
    }

    @PutMapping
    public ResponseEntity<String> orderProducts(@RequestBody Optional<Integer[]> ids){
        try {
            if (ids.isPresent()){
                int[] intArray = new int[ids.get().length];
                Integer[] integers = ids.get();
                for (int i = 0; i < ids.get().length; i++) {
                    intArray[i] = integers[i];
                }
               return new ResponseEntity<>(shopService.addOrder(intArray), HttpStatus.ACCEPTED);
            }
            else{
            return new ResponseEntity<>("No IDs in request body", HttpStatus.NOT_FOUND);}
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR, wrong Data", HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("{id}")
//    public ResponseEntity<String> getOrder(@PathVariable int id){
//        try {
//            return new ResponseEntity<>(shopService.getOrder(id), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Can not find order", HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping
    public List<String> getOrders(){
        return shopService.listOrders();
    }



}
