package com.kimseonhee126.myselectshop.repository;

import com.kimseonhee126.myselectshop.entity.Folder;
import com.kimseonhee126.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    List<Folder> findAllByUserAndNameIn(User user, List<String> folderNames);

    List<Folder> findAllByUser(User user);
}
