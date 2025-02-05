package com.kimseonhee126.myselectshop.repository;

import com.kimseonhee126.myselectshop.entity.Folder;
import com.kimseonhee126.myselectshop.entity.Product;
import com.kimseonhee126.myselectshop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFolderRepository extends JpaRepository<ProductFolder, Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
}
