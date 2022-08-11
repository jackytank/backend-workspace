package com.example.lab8.controller.rest;

import com.example.lab8.entity.Order;
import com.example.lab8.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping("")
    public Order create(@RequestBody JsonNode orderData){
        return orderService.create(orderData);
    }
}
