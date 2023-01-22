package com.jinju.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jinju.data.dto.ChangeProductNameDto;
import com.jinju.data.dto.ProductDto;
import com.jinju.data.dto.ProductResponseDto;
import com.jinju.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/test")
    public String testAPI(){
        LOGGER.info("test 호출됨");
        return "test OK";

    }


    //#region getMapping
    /**
     * getMapping
     * @param num
     * @return ResponseEntity.status(HttpStatus.OK).body(productResponseDto)
     */
    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long num) {
        ProductResponseDto productResponseDto = productService.getProduct(num);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@productResponseDto.toString()\n"+productResponseDto.toString());
        

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    //#endregion


    /**
     * PostMapping
     * @param productDto
     * @return ResponseEntity.status(HttpStatus.OK).body(productResponseDto)
     */
    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
    //public ResponseEntity<ProductResponseDto> createProduct(@RequestBody LinkedHashMap InfoMap) {
        

        
        System.out.println("controller_productDto : "+productDto);
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        System.out.println("@@@@@@@@productResponseDto : "+productResponseDto.toString());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }


    //#region PutMapping
    /**
     * PutMapping
     * @param changeProductNameDto
     * @return ResponseEntity.status(HttpStatus.OK).body(productResponseDto)
     * @throws Exception
     */
    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(
                changeProductNameDto.getNumber(),
                changeProductNameDto.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);

    }
    //#endregion

    

    //#region delMapping
    /**
     * delMapping
     * @param num
     * @return ResponseEntity.status(HttpStatus.OK).body("정상적 삭제완료")
     * @throws Exception
     */
    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long num) throws Exception {
        productService.deleteProduct(num);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
    //#endregion
}
