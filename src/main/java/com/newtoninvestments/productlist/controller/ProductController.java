package com.newtoninvestments.productlist.controller;

import com.newtoninvestments.productlist.dto.CreateProductRequestDto;
import com.newtoninvestments.productlist.dto.CreateProductResponseDto;
import com.newtoninvestments.productlist.dto.GetProductResponseDto;
import com.newtoninvestments.productlist.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateProductResponseDto create(@RequestBody CreateProductRequestDto request) {

        log.info("Create product request received");
        var product = service.create(request);
        log.info("Create product request successfully processed");

        return product;
    }

    @GetMapping(value = "{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetProductResponseDto getById(@PathVariable Long productId) {

        log.info("Get product by: " + productId + " request received");
        var product = service.getById(productId);
        log.info("Get product by: " + productId + " request successfully processed");

        return product;
    }
}
