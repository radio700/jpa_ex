package com.jinju.data.dao.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jinju.data.dao.ProductDAO;
import com.jinju.data.entity.Product;
import com.jinju.data.repository.ProductRepository;

@Component
public class ProductDAOImpl implements ProductDAO{

    private final ProductRepository productRepository;
    
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override//객체생성
    public Product insertProduct(Product product) {
        Product savedProduct  = productRepository.save(product);
        return savedProduct ;
    }

    @Override
    public Product selectProduct(Long num) {
        Product selectedProduct = productRepository.getReferenceById(num);
        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long num, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(num);

        System.out.println("파인드바이아이디 : "+selectedProduct);

        Product updatedProduct;

        if(selectedProduct.isPresent()){
            Product product = selectedProduct.get();
            System.out.println("파인드바이아이디.get한거 -> "+selectedProduct.get());

            product.setName(name);//이름 바꾸고
            product.setUpdatedAt(LocalDateTime.now());//upd넣고

            updatedProduct = productRepository.save(product);//세이브
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long num) throws Exception {
        Optional<Product> seletedProduct = productRepository.findById(num);

        if(seletedProduct.isPresent()){
            Product product = seletedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }

    
}
