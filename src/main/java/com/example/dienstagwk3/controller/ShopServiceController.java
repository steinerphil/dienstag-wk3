package com.example.dienstagwk3.controller;

import com.example.dienstagwk3.model.ProductInterface;
import com.example.dienstagwk3.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("shop")
public class ShopServiceController {

    private final ShopService shopService;

    @Autowired
    public ShopServiceController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<ProductInterface> getProduct(@RequestParam Optional<Integer> id){
        id.ifPresent(shopService::getProduct); //das gleiche wie if(id.isPresent){}
      return  shopService.listProducts();
    }



}
