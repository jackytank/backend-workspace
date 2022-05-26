package com.edu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.model.Product;

@Controller
@RequestMapping("product")
public class ProductController2 {
	@GetMapping("form2")
	public String form(ModelMap model) {
		Product product = new Product("Iphone XYZ", 23000);
		model.addAttribute("product1", product);
		return "product/form";
	}

	@PostMapping("save2")
	public String save(@ModelAttribute("product") Product product, ModelMap model) {
		model.addAttribute("product2", product);
		return "product/form";
	}
	
	@ModelAttribute("myList")
	public List<Product> getItems() {
		return Arrays.asList(new Product("A", 1), new Product("B", 2));
	}
}
