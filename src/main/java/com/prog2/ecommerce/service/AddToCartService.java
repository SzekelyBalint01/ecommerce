package com.prog2.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog2.ecommerce.repository.UserRepository;

@Service
public class AddToCartService {

    @Autowired
    private UserRepository repo;

    public void addProductId(int prodId, int userId) {

        System.out.println("Product ID:" + prodId + "User ID:" + userId);

    }

}