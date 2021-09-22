package com.example.dienstagwk3.controller;

import com.example.dienstagwk3.model.Order;
import com.example.dienstagwk3.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {

    private final ShopService shopService;

    @Autowired
    public OrderController(ShopService shopService) {
        this.shopService = shopService;
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

    @GetMapping("{id}")
    public ResponseEntity<String> getOrder(@PathVariable int id){
        try {
            return new ResponseEntity<>(shopService.getOrder(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Can not find order", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Order> getOrders(){
        return shopService.listOrders();
    }

    @DeleteMapping("{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable int orderId){
        try {
            return ResponseEntity.ok(shopService.cancelOrder(orderId));
        } catch (Exception e) {
            return new ResponseEntity<>("orderId does not match to order list.", HttpStatus.NOT_FOUND);
        }
    }

}
