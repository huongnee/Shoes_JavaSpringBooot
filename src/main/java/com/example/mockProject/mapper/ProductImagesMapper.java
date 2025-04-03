package com.example.mockProject.mapper;

import com.example.mockProject.dto.ProductImagesDTO;
import com.example.mockProject.entity.ProductImages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ProductImagesMapper {
    
    ProductImagesDTO toDTO(ProductImages productImages);
    
    List<ProductImagesDTO> toDTOList(List<ProductImages> productImages);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    ProductImages toEntity(ProductImagesDTO productImagesDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    void updateEntityFromDTO(ProductImagesDTO productImagesDTO, @MappingTarget ProductImages productImages);
} 