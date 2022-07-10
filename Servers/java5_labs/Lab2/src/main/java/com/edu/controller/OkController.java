package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OkController {
	@GetMapping("/ok")
	public String index() {
		return "ok";
	}

	@PostMapping("/ctrl/ok")
	public String m1(Model model) {
		model.addAttribute("result", "OK 1");
		return "ok";
	}

	@GetMapping("/ctrl/ok")
	public String m2(Model model) {
		model.addAttribute("result", "OK 2");
		return "ok";
	}

	@PostMapping(value = "/ctrl/ok", params = "x")
	public String m3(Model model) {
		model.addAttribute("result", "OK 3");
		return "ok";
	}

}
