package com.jinju.service;

import com.jinju.data.dto.ProductDto;
import com.jinju.data.dto.ProductResponseDto;

public interface ProductService {

    /**
     * getProduct
     * @param num
     * @return
     */
    ProductResponseDto getProduct(Long num);

    /**
     * saveProduct
     * @param productDto
     * @return
     */
    ProductResponseDto saveProduct(ProductDto productDto);

    /**
     * changeProductName
     * @param num
     * @param name
     * @return
     * @throws Exception
     */
    ProductResponseDto changeProductName(Long num, String name) throws Exception;

    /**
     * deleteProduct
     * @param num
     * @throws Exception
     */
    void deleteProduct(Long num) throws Exception;
}
