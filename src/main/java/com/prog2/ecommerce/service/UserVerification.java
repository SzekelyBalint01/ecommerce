package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.User;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserVerification extends UserService {


    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }


}
