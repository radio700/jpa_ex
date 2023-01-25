package com.jinju.data.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jinju.data.repository.ProductRepository;
import com.jinju.data.dto.ProductDto;
import com.jinju.data.dto.ProductResponseDto;
import com.jinju.data.entity.Product;

@SpringBootTest
public class ProductRepositoryTest {
    
    @Autowired//씨발 이거 필수네????????????????????????????????????????
    ProductRepository productRepository;

    // public ProductRepositoryTest(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    @Test
    void sortingAndPagingTest(){
        Product product1 = new Product();
        product1.setNum((long) 2);
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setIns_dttm(LocalDateTime.now());
        product1.setUpd_dttm(LocalDateTime.now());

        System.out.println(product1.toString());

        Product savedProduct1 = productRepository.save(product1);
        
    }

    
    @Test
    public void del(){
        productRepository.findByNumIs((long) 1);
    }



    
}
