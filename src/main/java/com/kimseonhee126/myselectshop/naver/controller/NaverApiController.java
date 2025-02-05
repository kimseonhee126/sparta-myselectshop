package com.kimseonhee126.myselectshop.naver.controller;

import com.kimseonhee126.myselectshop.naver.dto.ItemDto;
import com.kimseonhee126.myselectshop.naver.service.NaverApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NaverApiController {

    private final NaverApiService naverApiService;

    public NaverApiController(NaverApiService naverApiService) {
        this.naverApiService = naverApiService;
    }

    @GetMapping("/search")
    public List<ItemDto> searchItems(@RequestParam String query)  {
        return naverApiService.searchItems(query);
    }
}