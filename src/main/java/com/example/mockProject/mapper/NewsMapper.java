package com.example.mockProject.mapper;

import com.example.mockProject.dto.NewsDTO;
import com.example.mockProject.entity.News;
import com.example.mockProject.entity.NewsCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(uses = {NewsCategoryMapper.class})
public interface NewsMapper {
    
    @Mapping(target = "newsCategoryName", source = "newsCategory.name")
    NewsDTO toDTO(News news);
    
    @Mapping(target = "newsCategoryName", source = "newsCategory.name")
    List<NewsDTO> toDTOList(List<News> news);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "newsCategory", ignore = true)
    News toEntity(NewsDTO newsDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "newsCategory", ignore = true)
    void updateEntityFromDTO(NewsDTO newsDTO, @MappingTarget News news);
} 