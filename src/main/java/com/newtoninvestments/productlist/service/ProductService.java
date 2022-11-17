package com.newtoninvestments.productlist.service;

import com.newtoninvestments.productlist.dto.CreateProductRequestDto;
import com.newtoninvestments.productlist.dto.CreateProductResponseDto;
import com.newtoninvestments.productlist.dto.GetProductResponseDto;
import com.newtoninvestments.productlist.entity.ProductEntity;

public interface ProductService {

    CreateProductResponseDto create(CreateProductRequestDto request);
    GetProductResponseDto getById(Long productId);
    ProductEntity getByProductId(Long productId);
}
