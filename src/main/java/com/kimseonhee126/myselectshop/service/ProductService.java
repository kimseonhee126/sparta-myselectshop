package com.kimseonhee126.myselectshop.service;

import com.kimseonhee126.myselectshop.dto.ProductRequestDto;
import com.kimseonhee126.myselectshop.dto.ProductResponseDto;
import com.kimseonhee126.myselectshop.entity.Product;
import com.kimseonhee126.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }
}
