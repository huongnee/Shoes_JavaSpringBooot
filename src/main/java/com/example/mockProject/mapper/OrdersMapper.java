package com.example.mockProject.mapper;

import com.example.mockProject.dto.OrdersDTO;
import com.example.mockProject.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(uses = {OrdersDetailsMapper.class})
public interface OrdersMapper {
    
    @Mapping(target = "customerName", source = "customer.name")
    @Mapping(target = "transportMethodName", source = "transportMethod.name")
    @Mapping(target = "orderDetails", source = "ordersDetailsList")
    OrdersDTO toDTO(Orders orders);
    
    @Mapping(target = "customerName", source = "customer.name")
    @Mapping(target = "transportMethodName", source = "transportMethod.name")
    @Mapping(target = "orderDetails", source = "ordersDetailsList")
    List<OrdersDTO> toDTOList(List<Orders> orders);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "transportMethod", ignore = true)
    @Mapping(target = "ordersDetailsList", ignore = true)
    Orders toEntity(OrdersDTO ordersDTO);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "transportMethod", ignore = true)
    @Mapping(target = "ordersDetailsList", ignore = true)
    void updateEntityFromDTO(OrdersDTO ordersDTO, @MappingTarget Orders orders);
} 