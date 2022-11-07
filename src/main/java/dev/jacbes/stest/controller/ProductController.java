package dev.jacbes.stest.controller;

import dev.jacbes.stest.dto.ProductDto;
import dev.jacbes.stest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ProductDto saveProductEntity(@RequestBody ProductDto dto) {
        return productService.saveProductEntity(dto);
    }

    @GetMapping("/products")
    public List<ProductDto> fetchProductEntityList() {
        return productService.fetchProductEntityList();
    }

    @PutMapping("/products/{id}")
    public ProductDto updateProductEntity(@RequestBody ProductDto dto,
                                          @PathVariable("id") Long id) {
        return productService.updateProductEntity(dto, id);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductEntity(@PathVariable("id") Long id) {
        productService.deleteProductDto(id);
        return "Product deleted";
    }
}
