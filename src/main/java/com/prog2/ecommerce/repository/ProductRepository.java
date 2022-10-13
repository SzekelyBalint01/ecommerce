package com.prog2.ecommerce.repository;

import com.prog2.ecommerce.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Custom query
    @Query(value = "select p from Product p where p.name like %:keyword%")
    List<Product> findByKeyword( String keyword);
}
