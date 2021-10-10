package com.general.stores.naver.controller;

import com.general.stores.naver.models.NaverProduct;
import com.general.stores.naver.models.ProductMypriceRequestDto;
import com.general.stores.naver.models.ProductNaverRepository;
import com.general.stores.naver.models.ProductRequestDto;
import com.general.stores.naver.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

	private final ProductService productService;
    private final ProductNaverRepository productRepository;
    
 // 관심 상품 조회하기
    @GetMapping("/api/products")
    public List<NaverProduct> readProducts() {
        return productRepository.findAll();
    }
 // 관심 상품 등록
    @PostMapping("/api/products")
    public NaverProduct createProduct(@RequestBody ProductRequestDto requestDto) {
        NaverProduct product = new NaverProduct(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }

    @DeleteMapping("/api/products/{id}")
    public Long deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return id;
    }
}