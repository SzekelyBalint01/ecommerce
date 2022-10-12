package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {

        var users = (List<User>) repository.findAll();

        return users;
    }

    public abstract Optional<User> findById(Long aLong);
}