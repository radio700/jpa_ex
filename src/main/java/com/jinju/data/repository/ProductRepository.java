package com.jinju.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jinju.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
