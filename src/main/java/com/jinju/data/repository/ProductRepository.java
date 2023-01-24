package com.jinju.data.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jinju.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
// find..By (예제 8.1)
Optional<Product> findByNum(Long num);
List<Product> findAllByName(String name);
Product queryByNum(Long num);

// exists..By (예제 8.2)
boolean existsByNum(Long num);

// // count..By (예제 8.3)
long countByName(String name);

// // delete..By, remove..By (예제 8.4)
void deleteByNum(Long num);
long removeByName(String name);

// // …First<num>…, …Top<num>… (예제 8.5)
List<Product> findFirst5ByName(String name);
List<Product> findTop10ByName(String name);

// /* 쿼리 메소드의 조건자 키워드 */

// // Is, Equals (생략 가능) (예제 8.6)
// // Logical Keyword : IS , Keyword Expressions : Is, Equals, (or no keyword)
// // findByNum 메소드와 동일하게 동작
// Product findByNumIs(Long num);
// Product findByNumEquals(Long num);

// // (Is)Not (예제 8.7)
// Product findByNumIsNot(Long num);
// Product findByNumNot(Long num);

// // (Is)Null, (Is)NotNull (예제 8.8)
// List<Product> findByUpdatedAtNull();
// List<Product> findByUpdatedAtIsNull();
// List<Product> findByUpdatedAtNotNull();
// List<Product> findByUpdatedAtIsNotNull();

// // And, Or (예제 8.10)
// Product findByNumAndName(Long num, String name);
// Product findByNumOrName(Long num, String name);

// // (Is)GreaterThan, (Is)LessThan, (Is)Between (예제 8.11)
// List<Product> findByPriceIsGreaterThan(Long price);
// List<Product> findByPriceGreaterThan(Long price);
// List<Product> findByPriceGreaterThanEqual(Long price);
// List<Product> findByPriceIsLessThan(Long price);
// List<Product> findByPriceLessThan(Long price);
// List<Product> findByPriceLessThanEqual(Long price);
// List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
// List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

// // (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith (예제 8.12)
// List<Product> findByNameLike(String name);
// List<Product> findByNameIsLike(String name);

// List<Product> findByNameContains(String name);
// List<Product> findByNameContaining(String name);
// List<Product> findByNameIsContaining(String name);

// List<Product> findByNameStartsWith(String name);
// List<Product> findByNameStartingWith(String name);
// List<Product> findByNameIsStartingWith(String name);

// List<Product> findByNameEndsWith(String name);
// List<Product> findByNameEndingWith(String name);
// List<Product> findByNameIsEndingWith(String name);

// /* 정렬 처리하기 */

// // Asc : 오름차순, Desc : 내림차순 (예제 8.13)
// List<Product> findByNameOrderByNumAsc(String name);
// List<Product> findByNameOrderByNumDesc(String name);

// // 여러 정렬 기준 사용하기, And를 붙이지 않음 (예제 8.14)
// List<Product> findByNameOrderByPriceAscStockDesc(String name);

// // 매개변수를 활용한 정렬 방법 (예제 8.15)
// List<Product> findByName(String name, Sort sort);













}
