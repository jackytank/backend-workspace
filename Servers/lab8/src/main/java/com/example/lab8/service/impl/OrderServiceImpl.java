package com.example.lab8.service.impl;

import com.example.lab8.dao.OrderDAO;
import com.example.lab8.dao.OrderDetailDAO;
import com.example.lab8.entity.Order;
import com.example.lab8.entity.OrderDetail;
import com.example.lab8.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
        orderDAO.save(order);
        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>(){};
        List<OrderDetail> list = mapper.convertValue(orderData.get("orderDetails"), type)
                .stream().peek(o-> o.setOrder(order)).collect(Collectors.toList());
        orderDetailDAO.saveAll(list);
        return order;
    }

    @Override
    public Order findById(long id) {
        return orderDAO.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return orderDAO.findByUsername(username);
    }
}
