package com.example.mockProject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfigDTO {
    
    private Long id;
    
    @NotNull(message = "ID sản phẩm không được để trống")
    private Long idProduct;
    
    @NotNull(message = "ID cấu hình không được để trống")
    private Long idConfig;
    
    private String configName;
    
    private String value;
} 