package com.example.mockProject.mapper;

import com.example.mockProject.dto.OrdersDetailsDTO;
import com.example.mockProject.entity.OrdersDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface OrdersDetailsMapper {
    
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "productImage", source = "product.image")
    OrdersDetailsDTO toDTO(OrdersDetails ordersDetails);
    
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "productImage", source = "product.image")
    List<OrdersDetailsDTO> toDTOList(List<OrdersDetails> ordersDetails);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "product", ignore = true)
    OrdersDetails toEntity(OrdersDetailsDTO ordersDetailsDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "product", ignore = true)
    void updateEntityFromDTO(OrdersDetailsDTO ordersDetailsDTO, @MappingTarget OrdersDetails ordersDetails);
} 