package com.prog2.ecommerce.controller;

import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.service.IProductService;
import com.prog2.ecommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private IUserService UserService;

    @Autowired
    private IProductService ProductService;

    @GetMapping("/showUsers")
    public String findUsers(Model model) {

       var users = (List<User>) UserService.findAll();

        model.addAttribute("users", users);

        return "showUsers";
    }
    
    @GetMapping("/home")
    public String homePageContent(Model model) {

        var product = ProductService.findAll();

        model.addAttribute("product", product);

        return "home";
    }

    @GetMapping("/login")
    public  Boolean loginVerification(){



        return true;
    }
}