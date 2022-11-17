package com.newtoninvestments.productlist.service;

import com.newtoninvestments.productlist.dto.ProductListRequestDto;
import com.newtoninvestments.productlist.dto.ProductListResponseDto;
import com.newtoninvestments.productlist.entity.ProductListEntity;

public interface ProductListService {

    ProductListResponseDto create(ProductListRequestDto request);
    ProductListResponseDto addProduct(Long productListId, Long productId);
    ProductListResponseDto getById(Long productListId);
}
