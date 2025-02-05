package com.kimseonhee126.myselectshop.repository;

import com.kimseonhee126.myselectshop.entity.Product;
import com.kimseonhee126.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUser(User user);
}
