package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistration {

    @Autowired
    private UserRepository repository;

    public void addNewUser(String name, String password, String email) {

        User newUser = User.builder()
                .password(password)
                .email(email)
                .name(name)
                .build();

        newUser = repository.save(newUser);

    }

    public Boolean emailCheck(String email) {

        List<User> emailExistCheck = repository.findByEmail(email);

        if (emailExistCheck.isEmpty() == true) {
            return true;
        }

        return false;
    }

    public Optional<User> findById(Integer aLong) {
        return Optional.empty();
    };
}