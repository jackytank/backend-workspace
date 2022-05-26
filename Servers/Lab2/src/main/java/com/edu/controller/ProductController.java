package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.model.Product;

@Controller
@RequestMapping("product")
public class ProductController {
	@GetMapping("form")
	public String form() {
		return "form2";
	}

	@PostMapping("save")
	public String save(@ModelAttribute("prod") Product prod, Model model) {
		model.addAttribute("name",prod.getName());
		model.addAttribute("price",prod.getPrice());
		return "form2";
	}
}
