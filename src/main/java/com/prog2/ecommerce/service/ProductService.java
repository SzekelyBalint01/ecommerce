package com.prog2.ecommerce.service;

import com.prog2.ecommerce.model.Product;
import com.prog2.ecommerce.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {

        var product = (List<Product>)repository.findAll();

        return product;
    }

    public abstract Optional<Product> findById(Long aLong);
}