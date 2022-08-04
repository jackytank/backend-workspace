package com.example.lab8.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab8.dao.ProductDAO;
import com.example.lab8.entity.Product;
import com.example.lab8.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }
}
