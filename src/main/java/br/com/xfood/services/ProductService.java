package br.com.xfood.services;

import br.com.xfood.dtos.CreateProductDto;
import br.com.xfood.mappers.ProductMapper;
import br.com.xfood.models.ProductModel;
import br.com.xfood.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> getProductById(String id) {
        return productRepository.findById(id);
    }

    public ProductModel createProduct(CreateProductDto product) {
        return productRepository.save(productMapper.productDTOToProduct(product));
    }

    public ProductModel updateProduct(String id, CreateProductDto updatedProduct) {
        final var mappedProduct = new ProductModel(id, updatedProduct.name(), updatedProduct.description(), updatedProduct.price());
        return productRepository.save(mappedProduct);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
