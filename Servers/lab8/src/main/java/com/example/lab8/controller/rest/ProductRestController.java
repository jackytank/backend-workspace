package com.example.lab8.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.lab8.entity.Product;
import com.example.lab8.service.ProductService;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("/rest/products")
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/rest/products/{id}")
    public Product getOne(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    @PostMapping("/rest/products")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/rest/products/{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/rest/products/{id}")
    public void delete(@PathVariable("id") Integer id) {
        productService.delete(id);
    }


}
