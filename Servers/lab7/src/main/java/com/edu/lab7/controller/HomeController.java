package  com.edu.lab7.controller;

import java.util.Optional;

import  com.edu.lab7.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import  com.edu.lab7.dao.ProductDAO;

@Controller
public class HomeController {
	
	@RequestMapping("/home/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/home/about")
	public String about() {
		return "home/about";
	}
}
