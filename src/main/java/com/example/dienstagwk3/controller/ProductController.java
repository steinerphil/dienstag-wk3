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
@RequestMapping("product")
public class ProductController {

    private final ShopService shopService;

    @Autowired
    public ProductController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("{id}")
    public List<ProductInterface> getProduct(@PathVariable Optional<Integer> id){
        if(id.isPresent()) {
            return shopService.getProduct(id.get());
        }
      return  shopService.listProducts();
    }

    @GetMapping
    public ResponseEntity<ProductInterface> getProductByName(@RequestParam String name){
        try {
           return new ResponseEntity<>(shopService.getProductByName(name), HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
