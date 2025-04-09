package com.example.mockProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private UserDTO user;
    private List<OrderDetailDTO> orderDetails;
    private LocalDateTime orderDate;
    private String status;
    private double totalAmount;
} 