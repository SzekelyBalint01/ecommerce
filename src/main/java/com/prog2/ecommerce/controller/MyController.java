package com.prog2.ecommerce.controller;

import com.prog2.ecommerce.model.Product;
import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.service.ProductService;
import com.prog2.ecommerce.service.UserRegistration;
import com.prog2.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRegistration userRegistration;

    @GetMapping("/showUsers")
    public String findUsers(Model model) {

        var users = (List<User>) userService.findAll();

        model.addAttribute("users", users);

        return "showUsers";
    }

    @GetMapping("/home")
    public String homePageContent(Model model) {

        List<Product> productList = productService.findAll();

        model.addAttribute("productList", productList);

        return "home";
    }

    @GetMapping("/login")
    public Boolean loginVerification() {
        return true;
    }

    @RequestMapping(path = { "/search" })
    public String searchResult(Model model, String keyword) {
        List<Product> productList = productService.findByKeyword(keyword);
        model.addAttribute("productList", productList);

        return "searchResult";
    }

    @RequestMapping(path = { "/creatUser" })
    public String creatUser(Model model, String name, String email, String password) {
        
        userRegistration.addNewUser(0, name, password, email, password);

        return "home";
    }
}