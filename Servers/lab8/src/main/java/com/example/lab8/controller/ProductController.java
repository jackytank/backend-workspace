package com.example.lab8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lab8.dao.ProductDAO;
import com.example.lab8.entity.Product;
import com.example.lab8.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/product/list")
    public String list(ModelMap model) {
        List<Product> items = service.findAll();
        model.addAttribute("items",items);
        return "product/list";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail() {
        return "product/list";
    }
}