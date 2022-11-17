package com.newtoninvestments.productlist.mapper;

import com.newtoninvestments.productlist.dto.ProductListRequestDto;
import com.newtoninvestments.productlist.dto.ProductListResponseDto;
import com.newtoninvestments.productlist.entity.ProductListEntity;
import java.util.Objects;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductListMapper {

    private final ModelMapper mapper;

    @Autowired
    public ProductListMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProductListEntity toEntity(ProductListRequestDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, ProductListEntity.class);
    }

    public ProductListResponseDto toDto(ProductListEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ProductListResponseDto.class);
    }
}
