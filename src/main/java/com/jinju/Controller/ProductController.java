package com.jinju.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jinju.data.dto.ChangeProductNameDto;
import com.jinju.data.dto.ProductDto;
import com.jinju.data.dto.ProductResponseDto;
import com.jinju.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
public class ProductController {

    //http://localhost:8080/swagger-ui/index.html

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {

        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(ProductDto productDto) {

        System.out.println("productDto : "+ productDto);
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }


    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(
        @RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {

        ProductResponseDto productResponseDto = productService.changeProductName(
            changeProductNameDto.getNumber(),
            changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);

    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

<<<<<<< Updated upstream
=======
    
    @PostMapping("/qq")
    public ResponseEntity<ProductResponseDto> createProducte(ProductDto productDto) {

        System.out.println("productDto : "+ productDto);
        // ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        // return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
        return new ResponseEntity(HttpStatus.OK);

    }

>>>>>>> Stashed changes
}

