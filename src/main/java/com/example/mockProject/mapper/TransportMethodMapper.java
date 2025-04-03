package com.example.mockProject.mapper;

import com.example.mockProject.dto.TransportMethodDTO;
import com.example.mockProject.entity.TransportMethod;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface TransportMethodMapper {
    
    @Mapping(target = "orderCount", ignore = true)
    TransportMethodDTO toDTO(TransportMethod transportMethod);
    
    @Mapping(target = "orderCount", ignore = true)
    List<TransportMethodDTO> toDTOList(List<TransportMethod> transportMethods);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ordersList", ignore = true)
    TransportMethod toEntity(TransportMethodDTO transportMethodDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ordersList", ignore = true)
    void updateEntityFromDTO(TransportMethodDTO transportMethodDTO, @MappingTarget TransportMethod transportMethod);
} 