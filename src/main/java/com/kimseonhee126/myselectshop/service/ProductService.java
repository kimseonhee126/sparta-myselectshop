package com.kimseonhee126.myselectshop.service;

import com.kimseonhee126.myselectshop.dto.ProductMypriceRequestDto;
import com.kimseonhee126.myselectshop.dto.ProductRequestDto;
import com.kimseonhee126.myselectshop.dto.ProductResponseDto;
import com.kimseonhee126.myselectshop.entity.Product;
import com.kimseonhee126.myselectshop.naver.dto.ItemDto;
import com.kimseonhee126.myselectshop.repository.ProductRepository;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public static final int int_MIN_MY_PRICE = 100;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        int myprice = requestDto.getMyprice();

        if (myprice < int_MIN_MY_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + int_MIN_MY_PRICE + "원 이상으로 설정해 주세요.");
        }

        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품을 찾을 수 없습니다.")
        );

        product.update(requestDto);

        return new ProductResponseDto(product);
    }

    public List<ProductResponseDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 상품은 존재하지 않습니다.")
        );

        product.updateByItemDto(itemDto);
    }
}
