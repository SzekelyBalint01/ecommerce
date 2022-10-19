package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.Cart;
import com.prog2.ecommerce.model.CartKey;
import com.prog2.ecommerce.model.User;
import com.prog2.ecommerce.model.Product;
import com.prog2.ecommerce.repository.CartRepository;
import com.prog2.ecommerce.repository.ProductRepository;
import com.prog2.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public List<Product> findAll() {

        List<Product> product = repository.findAll();
        return product;
    }

    public List<Product> findByKeyword(String keyword) {
        List<Product> product = repository.findByKeyword(keyword);
        return product;
    }

    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    };

    @Transactional
    public void addProductId(Integer prodId, Integer userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException());

        Product product = repository.findById(prodId).orElseThrow(() -> new EntityNotFoundException());

        Cart cart = Cart.builder()
                .user(user)
                .product(product)
                .cartKey(new CartKey(userId, prodId))
                .build();

        cartRepository.save(cart);
    }
}