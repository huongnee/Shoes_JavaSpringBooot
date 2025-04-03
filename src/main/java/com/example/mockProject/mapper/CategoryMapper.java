package com.example.mockProject.mapper;

import com.example.mockProject.dto.CategoryDTO;
import com.example.mockProject.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface CategoryMapper {
    
    @Mapping(target = "productCount", ignore = true)
    @Mapping(target = "parentName", ignore = true)
    CategoryDTO toDTO(Category category);
    
    @Mapping(target = "productCount", ignore = true)
    @Mapping(target = "parentName", ignore = true)
    List<CategoryDTO> toDTOList(List<Category> categories);
    
    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);
    
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(CategoryDTO categoryDTO, @MappingTarget Category category);
} 