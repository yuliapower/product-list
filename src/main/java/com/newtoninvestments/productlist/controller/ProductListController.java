package com.newtoninvestments.productlist.controller;

import com.newtoninvestments.productlist.dto.ProductListRequestDto;
import com.newtoninvestments.productlist.dto.ProductListResponseDto;
import com.newtoninvestments.productlist.service.ProductListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product-list")
public class ProductListController {

    private final ProductListService service;

    @Autowired
    public ProductListController(ProductListService service) {
        this.service = service;
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ProductListResponseDto create(@RequestBody ProductListRequestDto request) {

        log.info("Create product list request received");
        var productList = service.create(request);
        log.info("Create product list request successfully processed");

        return productList;
    }

    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductListResponseDto addProduct(
        @RequestParam Long productListId,
        @RequestParam Long productId
    ) {

        log.info("Add product with " + productListId + " and " + productId
            + " to product list request received");
        var productList = service.addProduct(productListId, productId);
        log.info("Add product with " + productListId + " and " + productId
            + " to product list successfully processed");

        return productList;
    }

    @GetMapping(value = "/{productListId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductListResponseDto getByProductListId(@PathVariable Long productListId) {

        log.info("Create product list by productListId = " + productListId + " request received");
        var productList = service.getById(productListId);
        log.info("Create product list by productListId = " + productListId + " request received");

        return productList;
    }
}
