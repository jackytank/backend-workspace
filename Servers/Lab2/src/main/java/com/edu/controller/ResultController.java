package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ResultController {
	@GetMapping("a")
	public String m1() {
		return "a";
	}

	@GetMapping("b")
	public ModelAndView m2(ModelMap model) {
		model.addAttribute("message", "I come form b");
		return new ModelAndView("redirect:/a", model);
	}

	@GetMapping("c")
	public RedirectView m3(RedirectAttributes param) {
		param.addAttribute("message", "I come form c");
		return new RedirectView("a");
	}

	@ResponseBody
	@GetMapping("/d")
	public String m4() {
		return "This is JSON format - I come from d";
	}

}
