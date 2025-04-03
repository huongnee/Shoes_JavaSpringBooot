package com.example.mockProject.mapper;

import com.example.mockProject.dto.CustomerDTO;
import com.example.mockProject.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CustomerMapper {
    
    CustomerDTO toDTO(Customer customer);
    
    List<CustomerDTO> toDTOList(List<Customer> customers);
    
    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDTO customerDTO);
    
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(CustomerDTO customerDTO, @MappingTarget Customer customer);
} 