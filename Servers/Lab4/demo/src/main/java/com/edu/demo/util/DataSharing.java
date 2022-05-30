package com.edu.demo.util;

import java.util.HashMap;

import com.edu.demo.entity.Products;

public class DataSharing {
    public static HashMap<Integer, Products> products = new HashMap<>();

    static {
        // Add product into products list
        products.put(1, new Products(1, "Laptop Dell Inspiron", 15000000d, 15,
                "This is Laptop Gaming", "money.jpg"));
        products.put(2, new Products(2, "Laptop Asus TUF", 18000000d, 10,
                "This is Laptop Gaming", "money.jpg"));
        products.put(3, new Products(3, "Laptop Asus ROG", 25000000d, 25,
                "This is Laptop Gaming", "money.jpg"));
        products.put(4, new Products(4, "Iphone 13 Pro Max", 32000000d, 30,
                "This is phone of Apple ", "money.jpg"));
        products.put(5, new Products(5, "Samsung 22 Ultra", 28000000d, 27,
                "This is phone of Samsung", "money.jpg"));
    }
}
