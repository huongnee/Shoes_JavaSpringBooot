package com.example.mockProject.mapper;

import com.example.mockProject.dto.ProductConfigDTO;
import com.example.mockProject.entity.ProductConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ProductConfigMapper {
    
    @Mapping(target = "configName", source = "config.name")
    ProductConfigDTO toDTO(ProductConfig productConfig);
    
    @Mapping(target = "configName", source = "config.name")
    List<ProductConfigDTO> toDTOList(List<ProductConfig> productConfigs);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "config", ignore = true)
    ProductConfig toEntity(ProductConfigDTO productConfigDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "config", ignore = true)
    void updateEntityFromDTO(ProductConfigDTO productConfigDTO, @MappingTarget ProductConfig productConfig);
} 