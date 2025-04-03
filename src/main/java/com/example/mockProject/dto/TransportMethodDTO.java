package com.example.mockProject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportMethodDTO {
    
    private Long id;
    
    @NotBlank(message = "Tên phương thức vận chuyển không được để trống")
    private String name;
    
    private String notes;
    
    private LocalDateTime createdDate;
    
    private LocalDateTime updatedDate;
    
    private Integer isDelete;
    
    private Integer isActive;
    
    private Long orderCount;
} 