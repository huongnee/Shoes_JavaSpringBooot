package com.example.mockProject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationsDTO {
    
    private Long id;
    
    @NotBlank(message = "Tên cấu hình không được để trống")
    private String name;
    
    private String notes;
    
    private Integer isDelete;
    
    private Integer isActive;
} 