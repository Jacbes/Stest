package dev.jacbes.stest.service;

import dev.jacbes.stest.data.ProductRepository;
import dev.jacbes.stest.dto.ProductDto;
import dev.jacbes.stest.entity.ProductEntity;
import dev.jacbes.stest.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MappingUtils mappingUtils;

    @Override
    public ProductDto saveProductEntity(ProductDto dto) {
        return mappingUtils.mapToProductDto(productRepository.save(mappingUtils.mapToProductEntity(dto)));
    }

    @Override
    public List<ProductDto> fetchProductEntityList() {
        return productRepository.findAll().stream()
                .map(entity -> mappingUtils.mapToProductDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProductEntity(ProductDto dto, Long id) {
        ProductEntity entityDto = mappingUtils.mapToProductEntity(dto);
        ProductEntity entityDB = productRepository.findById(id).get();

        if (Objects.nonNull(entityDto.getName())
                && "".equalsIgnoreCase(entityDto.getName())) {
            entityDB.setName(entityDto.getName());
        }

        if (Objects.nonNull(entityDto.getPrice())) {
            entityDB.setPrice(entityDto.getPrice());
        }

        return mappingUtils.mapToProductDto(productRepository.save(entityDto));
    }

    @Override
    public void deleteProductDto(Long id) {
        productRepository.deleteById(id);
    }
}
