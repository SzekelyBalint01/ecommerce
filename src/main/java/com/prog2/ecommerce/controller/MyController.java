package com.prog2.ecommerce.controller;

import com.prog2.ecommerce.model.Product;
import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.service.AddToCartService;
import com.prog2.ecommerce.service.ProductService;
import com.prog2.ecommerce.service.UserRegistration;
import com.prog2.ecommerce.service.UserService;
import com.prog2.ecommerce.controller.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        // if true, than the email not exsist yet.
        if (userRegistration.emailCheck(email) == true) {

            var users = (List<User>) userService.findAll();
            int lenght = users.size();
            userRegistration.addNewUser(lenght + 1, name, password, email, password);

            return "home";
        }

        return "404";
    }

    @RequestMapping(path = { "/loggedHome" })
    public String loginUser(Model model, String email, String password) {

        if (userService.loginCheck(email, password) != null) {

            List<Product> productList = productService.findAll();
            model.addAttribute("productList", productList);
            User user = userService.loginCheck(email, password);
            model.addAttribute("acceptedUser", user);
            return "loggedHome";
        }
        return "404";
    }
}

@RestController
@RequestMapping("/addToCartPost")
class UserController {

    @Autowired
    private AddToCartService addToCartService;

    @PostMapping(produces = "application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<CartResponse> search(@RequestBody MultiValueMap<String, String> formData) {

        int userId = Integer.parseInt(formData.getFirst("userId"));

        int productId = Integer.parseInt(formData.getFirst("productId"));

        addToCartService.addProductId(productId, userId);

        CartResponse es = new CartResponse();

        // es.setadded(CartResponse.main(userId, productId));

        return ResponseEntity.ok(es);

    }
}