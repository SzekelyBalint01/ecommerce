package com.prog2.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog2.ecommerce.model.Cart;
import com.prog2.ecommerce.model.CartKey;

public interface CartRepository extends JpaRepository<Cart, CartKey> {

    List<Cart> findByUserId(Long userId);
}
