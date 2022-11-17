package com.newtoninvestments.productlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class ProductListRequestDto {

    @JsonProperty("name")
    private String name;
}
