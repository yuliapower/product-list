package com.newtoninvestments.productlist.mapper;


import com.newtoninvestments.productlist.dto.CreateProductRequestDto;
import com.newtoninvestments.productlist.dto.CreateProductResponseDto;
import com.newtoninvestments.productlist.dto.GetProductResponseDto;
import com.newtoninvestments.productlist.entity.ProductEntity;
import java.util.Objects;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final ModelMapper mapper;

    @Autowired
    public ProductMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProductEntity toProductEntity(CreateProductRequestDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, ProductEntity.class);
    }

    public CreateProductResponseDto toCreateProductResponseDto(ProductEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CreateProductResponseDto.class);
    }

    public GetProductResponseDto toDto(ProductEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, GetProductResponseDto.class);
    }
}
