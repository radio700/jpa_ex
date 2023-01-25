package com.jinju.data.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

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
        product1.setNum((long) 3);
        product1.setName("컴퓨터");
        product1.setPrice(1000);
        product1.setStock(100);
        product1.setIns_dttm(LocalDateTime.now());
        product1.setUpd_dttm(LocalDateTime.now());

        System.out.println(product1.toString());

        Product savedProduct1 = productRepository.save(product1);

        System.out.println("@@@@savedProduct1 : "+savedProduct1);

        productRepository.findByName("컴퓨터",겟쏘트());//함수로 분리 할 수 도 있다

        
        
    }
    //오더바이 코드가 길 경우 따로 따로 쓸 수 있다
    private Sort 겟쏘트(){
        return Sort.by(
            Order.asc("price"),
            Order.desc("stock")
        );
    }

    
    @Test
    public void 이름으로찾고_값으로_오름차순(){
        // productRepository.findByNumIs((long) 1);
        //productRepository.findByNameOrderByNumAsc("컴퓨터");
        productRepository.findByName("컴퓨터", Sort.by(Order.asc("price")));//씨발 쿼리보다 더어렵네
        
    }

    @Test
    public void 페이징_처리(){
        Page<Product> productPage = productRepository.findByName("컴퓨터", PageRequest.of(0, 2));
        System.out.println(productPage.getContent());
        
    }







    
}
