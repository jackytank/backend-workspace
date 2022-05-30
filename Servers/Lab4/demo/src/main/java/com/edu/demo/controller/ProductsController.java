package com.edu.demo.controller;

import com.edu.demo.util.DataSharing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", DataSharing.products.values());
        return "index";
    }
}
