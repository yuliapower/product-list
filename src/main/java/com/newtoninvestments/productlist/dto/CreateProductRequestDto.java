package com.newtoninvestments.productlist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class CreateProductRequestDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("kcal")
    private Integer kcal;
}
