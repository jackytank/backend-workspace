package com.edu.demo.service;

import java.util.Map;

import com.edu.demo.entity.Products;

public interface ShoppingCartService {
    void addProduct(Integer id);

    void removeProduct(Integer id);

    void updateProduct(Integer id, int qty);

    void clear();

    Map<Integer, Products> getProducts();

    int getCount();

    double getAmount();
}
