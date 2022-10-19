package com.prog2.ecommerce.repository;

import com.prog2.ecommerce.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Custom query
    @Query(value = "select p from User p where p.email like %:email%")
    List<User> findByEmail(String email);

}