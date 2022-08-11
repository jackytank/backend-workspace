package com.example.lab8.service;

import com.example.lab8.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface OrderService {
    Order create(JsonNode orderData);

    Order findById(long id);

    List<Order> findByUsername(String username);
}