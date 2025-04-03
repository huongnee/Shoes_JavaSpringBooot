package com.example.mockProject.mapper;

import com.example.mockProject.dto.ConfigurationsDTO;
import com.example.mockProject.entity.Configurations;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ConfigurationsMapper {
    
    ConfigurationsDTO toDTO(Configurations configurations);
    
    List<ConfigurationsDTO> toDTOList(List<Configurations> configurations);
    
    @Mapping(target = "id", ignore = true)
    Configurations toEntity(ConfigurationsDTO configurationsDTO);
    
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ConfigurationsDTO configurationsDTO, @MappingTarget Configurations configurations);
} 