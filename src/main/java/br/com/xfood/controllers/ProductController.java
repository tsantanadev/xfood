package br.com.xfood.controllers;

import br.com.xfood.dtos.CreateProductDto;
import br.com.xfood.dtos.ProductDto;
import br.com.xfood.mappers.ProductMapper;
import br.com.xfood.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::productToProductDto).toList();
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProductById(@PathVariable String id) {
        return productService.getProductById(id).map(productMapper::productToProductDto);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody CreateProductDto product) {
        final var createdProduct =  productService.createProduct(product);
        return productMapper.productToProductDto(createdProduct);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable String id, @RequestBody CreateProductDto updatedProduct) {
        final var persistedProduct = productService.updateProduct(id, updatedProduct);
        return productMapper.productToProductDto(persistedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
