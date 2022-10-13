package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        var users = (List<User>) repository.findAll();

        return users;
    }

    public Optional<User> findById(Long aLong){
        return repository.findById(aLong);
    };
}