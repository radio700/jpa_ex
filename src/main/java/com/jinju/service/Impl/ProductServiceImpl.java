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



    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        System.out.println("Service_product : "+product);
        System.out.println("Service_product.getNum() : "+product.getNum());

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNum(product.getNum());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
        
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);
        System.out.println("service_saveProduct : "+ saveProduct);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNum(saveProduct.getNum());
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changedProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setNum(changedProduct.getNum());
        productResponseDto.setName(changedProduct.getName());
        productResponseDto.setPrice(changedProduct.getPrice());
        productResponseDto.setStock(changedProduct.getStock());
        

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
        
    }
    
}
