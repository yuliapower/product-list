package com.newtoninvestments.productlist.service.impl;

import com.newtoninvestments.productlist.dto.ProductListRequestDto;
import com.newtoninvestments.productlist.dto.ProductListResponseDto;
import com.newtoninvestments.productlist.entity.ProductEntity;
import com.newtoninvestments.productlist.entity.ProductListEntity;
import com.newtoninvestments.productlist.exception.ProductAlreadyAddedToListException;
import com.newtoninvestments.productlist.exception.ProductListNotFoundException;
import com.newtoninvestments.productlist.mapper.ProductListMapper;
import com.newtoninvestments.productlist.repository.ProductListRepository;
import com.newtoninvestments.productlist.service.ProductListService;
import com.newtoninvestments.productlist.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductListServiceImpl implements ProductListService {

    private final ProductService productService;
    private final ProductListRepository repository;
    private final ProductListMapper mapper;

    @Autowired
    public ProductListServiceImpl(ProductService productService, ProductListRepository repository,
        ProductListMapper mapper) {
        this.productService = productService;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductListResponseDto create(ProductListRequestDto request) {
        var productListEntity = repository.save(mapper.toEntity(request));
        return mapper.toDto(productListEntity);
    }

    @Override
    public ProductListResponseDto addProduct(Long productListId, Long productId) {

        var productList = getProductListById(productListId);
        var product = productService.getByProductId(productId);

        assertProductAlreadyAddedToList(product);

        productList.addProduct(product);
        repository.save(productList);
        return mapper.toDto(productList);
    }


    @Override
    public ProductListResponseDto getById(Long productListId) {

        var productListEntity = getProductListById(productListId);
        var sumKcal = calculateSumKcal(productListEntity);

        var productListDto = mapper.toDto(productListEntity);
        productListDto.setSumKcal(sumKcal);

        return productListDto;
    }

    private int calculateSumKcal(ProductListEntity productListEntity) {
        return productListEntity
            .getProducts()
            .stream()
            .mapToInt(ProductEntity::getKcal)
            .sum();
    }

    private void assertProductAlreadyAddedToList(ProductEntity product) {
        if (product.getProductList() != null) {
            log.error("Product with id = " + product.getId() + " already exist");
            throw new ProductAlreadyAddedToListException();
        }
    }

    private ProductListEntity getProductListById(Long productListId) {
        return repository
            .findById(productListId)
            .orElseThrow(() -> {
                log.error("Not found product list with id = " + productListId);
                return new ProductListNotFoundException();
            });
    }
}
