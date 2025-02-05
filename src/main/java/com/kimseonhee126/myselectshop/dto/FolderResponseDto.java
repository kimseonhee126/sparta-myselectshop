package com.kimseonhee126.myselectshop.dto;

import com.kimseonhee126.myselectshop.entity.Folder;

import lombok.Getter;

@Getter
public class FolderResponseDto {
    private Long id;
    private String name;

    public FolderResponseDto(Folder folder) {
        this.id = folder.getId();
        this.name = folder.getName();
    }
}
