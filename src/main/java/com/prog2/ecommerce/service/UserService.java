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

        List<User> users = repository.findAll();
        return users;
    }

   

    public User loginCheck(String email, String password){
        
        for (int i = 0; i < findAll().size(); i++) {
            
            String tempEmail = findAll().get(i).getEmail();
            String tempPassword = findAll().get(i).getPassword();
            Long id ;
            if (tempEmail.equals(email) && tempPassword.equals(password)) {
            
             

           // return user;
           }
        }
       
      return null;
    }


    public Optional<User> findById(Long aLong){
        return repository.findById(aLong);
    };
}