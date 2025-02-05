package com.kimseonhee126.myselectshop.repository;

import com.kimseonhee126.myselectshop.entity.Product;
import com.kimseonhee126.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUser(User user, Pageable pageable);
}
