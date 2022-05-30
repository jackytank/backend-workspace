package com.edu.demo.controller;

import com.edu.demo.service.ParamService;
import com.edu.demo.service.SessionService;
import com.edu.demo.service.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    ShoppingCartService cart;

    @Autowired
    ParamService param;

    @Autowired
    SessionService session;

    @GetMapping("/view")
    public String getLogin(Model model) {
        model.addAttribute("cart", cart.getProducts());
        model.addAttribute("amount", cart.getAmount());
        return "cart1";
    }

    @GetMapping(value = "/add/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView addToCart(@PathVariable int id, ModelMap model) {
        cart.addProduct(id);
        session.set("cartQuantity", cart.getCount());
        model.addAttribute("message", "Add success!!");
        return new ModelAndView("forward:/cart/view", model);
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateCart(@PathVariable int id, ModelMap model) {
        cart.updateProduct(id, param.getInt("quantity", 0));
        model.addAttribute("message", "Update success!");
        return new ModelAndView("redirect:/cart/view", model);
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removeFromCart(@PathVariable int id, ModelMap model) {
        cart.removeProduct(id);
        model.addAttribute("message", "Remove success!");
        return new ModelAndView("redirect:/cart/view", model);
    }

    @GetMapping("/clear")
    public ModelAndView clearCart(ModelMap model) {
        cart.clear();
        model.addAttribute("message", "Clear success!");
        return new ModelAndView("redirect:/cart/view", model);
    }
}
