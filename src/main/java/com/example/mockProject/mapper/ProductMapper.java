package com.example.mockProject.mapper;

import com.example.mockProject.dto.ProductDTO;
import com.example.mockProject.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(uses = {ProductImagesMapper.class, ProductConfigMapper.class})
public interface ProductMapper {
    
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "productImages", source = "productImagesList")
    @Mapping(target = "productConfigs", source = "productConfigList")
    ProductDTO toDTO(Product product);
    
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "productImages", source = "productImagesList")
    @Mapping(target = "productConfigs", source = "productConfigList")
    List<ProductDTO> toDTOList(List<Product> products);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "productImagesList", ignore = true)
    @Mapping(target = "productConfigList", ignore = true)
    @Mapping(target = "ordersDetailsList", ignore = true)
    Product toEntity(ProductDTO productDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "productImagesList", ignore = true)
    @Mapping(target = "productConfigList", ignore = true)
    @Mapping(target = "ordersDetailsList", ignore = true)
    void updateEntityFromDTO(ProductDTO productDTO, @MappingTarget Product product);
} 