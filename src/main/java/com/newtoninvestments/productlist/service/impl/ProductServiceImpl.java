package com.newtoninvestments.productlist.service.impl;

import com.newtoninvestments.productlist.dto.CreateProductRequestDto;
import com.newtoninvestments.productlist.dto.CreateProductResponseDto;
import com.newtoninvestments.productlist.dto.GetProductResponseDto;
import com.newtoninvestments.productlist.entity.ProductEntity;
import com.newtoninvestments.productlist.exception.ProductListNotFoundException;
import com.newtoninvestments.productlist.exception.ProductNotFoundException;
import com.newtoninvestments.productlist.mapper.ProductMapper;
import com.newtoninvestments.productlist.repository.ProductRepository;
import com.newtoninvestments.productlist.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CreateProductResponseDto create(CreateProductRequestDto request) {
        ProductEntity productEntity = repository.save(mapper.toProductEntity(request));
        return mapper.toCreateProductResponseDto(productEntity);
    }

    @Override
    public GetProductResponseDto getById(Long productId) {
        return mapper.toDto(getByProductId(productId));
    }

    @Override
    public ProductEntity getByProductId(Long productId) {
        return repository
            .findById(productId)
            .orElseThrow(() -> {
                log.error("Not found product with id = " + productId);
                return new ProductNotFoundException();
            });
    }
}
