package com.prog2.ecommerce.service;

import java.util.List;

import com.prog2.ecommerce.model.Product;

public interface IProductService {
    List<Product> findAll();
}
