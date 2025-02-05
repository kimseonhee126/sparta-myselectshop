package com.kimseonhee126.myselectshop.repository;

import com.kimseonhee126.myselectshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
