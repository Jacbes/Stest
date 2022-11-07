package dev.jacbes.stest.service;

import dev.jacbes.stest.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto saveProductEntity(ProductDto entity);

    List<ProductDto> fetchProductEntityList();

    ProductDto updateProductEntity(ProductDto entity, Long id);

    void deleteProductDto(Long id);
}
