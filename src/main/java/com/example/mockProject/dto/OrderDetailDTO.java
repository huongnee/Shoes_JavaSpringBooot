package com.example.mockProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    private Long id;
    private OrderDTO order;
    private ProductDTO product;
    private int quantity;
    private double price;
} 