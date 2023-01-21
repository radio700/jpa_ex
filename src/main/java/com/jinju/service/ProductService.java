package com.jinju.service;

import com.jinju.data.dto.ProductDto;
import com.jinju.data.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto getProduct(Long num);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long num, String name) throws Exception;

    void deleteProduct(Long num) throws Exception;
}
