package com.jinju.data.dao;

import com.jinju.data.entity.Product;

public interface ProductDAO {
    Product insertProduct(Product product);

    Product selectProduct(Long num);

    Product updateProductName(Long num, String name) throws Exception;

    void deleteProduct(Long num) throws Exception;
}
