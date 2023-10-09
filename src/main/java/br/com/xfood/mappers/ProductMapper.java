package br.com.xfood.mappers;

import br.com.xfood.dtos.CreateProductDto;
import br.com.xfood.dtos.ProductDto;
import br.com.xfood.models.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductDto productToProductDto(ProductModel product);

    ProductModel productDTOToProduct(CreateProductDto productDTO);
}
