package com.example.mockProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImagesDTO {
    
    private Long id;
    
    private String name;
    
    @NotBlank(message = "URL hình ảnh không được để trống")
    private String urlImg;
    
    @NotNull(message = "ID sản phẩm không được để trống")
    private Long idProduct;
} 