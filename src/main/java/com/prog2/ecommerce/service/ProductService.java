package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.Product;
import com.prog2.ecommerce.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

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
}