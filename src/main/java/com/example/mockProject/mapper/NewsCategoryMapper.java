package com.example.mockProject.mapper;

import com.example.mockProject.dto.NewsCategoryDTO;
import com.example.mockProject.entity.NewsCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface NewsCategoryMapper {
    
    @Mapping(target = "newsCount", ignore = true)
    @Mapping(target = "parentName", ignore = true)
    NewsCategoryDTO toDTO(NewsCategory newsCategory);
    
    @Mapping(target = "newsCount", ignore = true)
    @Mapping(target = "parentName", ignore = true)
    List<NewsCategoryDTO> toDTOList(List<NewsCategory> newsCategories);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "newsList", ignore = true)
    NewsCategory toEntity(NewsCategoryDTO newsCategoryDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "newsList", ignore = true)
    void updateEntityFromDTO(NewsCategoryDTO newsCategoryDTO, @MappingTarget NewsCategory newsCategory);
} 