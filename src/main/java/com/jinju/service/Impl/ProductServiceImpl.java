package com.jinju.service.Impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jinju.data.dto.ProductDto;
import com.jinju.data.dto.ProductResponseDto;
import com.jinju.data.entity.Product;
import com.jinju.data.repository.ProductRepository;
import com.jinju.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    /**
     * getProduct
     * @param num
     * @return productResponseDto
     */
    @Override
    public ProductResponseDto getProduct(Long num) {
        LOGGER.info("[getProduct] input number : {}", num);
        Product product = productRepository.findById(num).get();

        System.out.println("Service_product : "+product);

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
        LOGGER.info("[saveProduct] productDTO : {}", productDto.toString());
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setIns_dttm(LocalDateTime.now());
        product.setUpd_dttm(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);
        LOGGER.info("[saveProduct] savedProduct : {}", savedProduct);

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
        Product foundProduct = productRepository.findById(num).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

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
        productRepository.deleteById(num);
        
    }
    
}
