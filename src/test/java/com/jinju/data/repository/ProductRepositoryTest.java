package com.jinju.data.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jinju.data.entity.Product;

@SpringBootTest
public class ProductRepositoryTest {
    

    ProductRepository productRepository;


    @Test
    void sortingAndPagingTest(){
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setIns_dttm(LocalDateTime.now());
        product1.setUpd_dttm(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setIns_dttm(LocalDateTime.now());
        product2.setUpd_dttm(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setIns_dttm(LocalDateTime.now());
        product3.setUpd_dttm(LocalDateTime.now());


        // Product savedProduct1 = productRepository.save(product1);
        // Product savedProduct2 = productRepository.save(product2);
        // Product savedProduct3 = productRepository.save(product3);

        System.out.println("savedProduct1 : "+product1);
        System.out.println("savedProduct2 : "+product2);
        System.out.println("savedProduct3 : "+product3);


        // System.out.println(productRepository.findByNameOrderByNumAsc("펜"));
        // System.out.println(productRepository.findByNameOrderByNumDesc("펜"));
// 

        // System.out.println(productRepository.findByName("펜", Sort.by(Order.asc("price"))));
        // System.out.println(productRepository.findByName("펜", Sort.by(Order.asc("price"), Order.desc("stock"))));
    }
}
