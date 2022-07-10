package com.edu.demo.controller;

import com.edu.demo.util.DataSharing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ProductsController {
    @GetMapping("/products")
    public String getProducts(@ModelAttribute("message") String message, ModelMap model) {
        model.addAttribute("products", DataSharing.products.values());
        model.addAttribute("message", message);
        return "index";
    }
}
