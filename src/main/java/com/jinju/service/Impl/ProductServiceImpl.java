package com.jinju.service.Impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jinju.data.dao.ProductDAO;
import com.jinju.data.dto.ProductDto;
import com.jinju.data.dto.ProductResponseDto;
import com.jinju.data.entity.Product;
import com.jinju.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }



    /**
     * getProduct
     * @param num
     * @return productResponseDto
     */
    @Override
    public ProductResponseDto getProduct(Long num) {
        Product product = productDAO.selectProduct(num);

        System.out.println("Service_product : "+product);
        System.out.println("Service_product.getNum() : "+product.getNum());

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNum(product.getNum());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
        
    }


    /**
     * saveProduct
     * @param productDto
     * @return productResponseDto
     */
    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = productDAO.insertProduct(product);
        System.out.println("service_saveProduct : "+ savedProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNum(savedProduct.getNum());
        productResponseDto.setName(savedProduct.getName());
        productResponseDto.setPrice(savedProduct.getPrice());
        productResponseDto.setStock(savedProduct.getStock());

        return productResponseDto;
    }


    /**
     * changeProductName
     * @param num
     * @param name
     * @return productResponseDto
     * @throws Exception
     */
    @Override
    public ProductResponseDto changeProductName(Long num, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(num, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNum(changedProduct.getNum());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());

        return productResponseDto;
    }


    /**
     * deleteProduct
     * @param num
     * @throws Exception
     */
    @Override
    public void deleteProduct(Long num) throws Exception {
        productDAO.deleteProduct(num);
        
    }
    
}
