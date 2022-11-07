package dev.jacbes.stest.utils;

import dev.jacbes.stest.dto.ProductDto;
import dev.jacbes.stest.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public ProductDto mapToProductDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public ProductEntity mapToProductEntity(ProductDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}
