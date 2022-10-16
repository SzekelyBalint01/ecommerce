package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistration{

    @Autowired
    private UserRepository repository;
    
    public void addNewUser(int id, String name, String password, String email, String address) {
        
        User newUser = new User(id, name, password, email, address);
        newUser = repository.save(newUser);

    }

    public Boolean emailCheck(String email){

        List<User> emailExistCheck = repository.findByEmail(email);

        if(emailExistCheck.isEmpty()==true){
            return true;
        }

        return false;
    }

    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    };
}