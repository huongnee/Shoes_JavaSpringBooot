package com.example.mockProject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    
    private Long id;
    
    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(max = 500, message = "Tên sản phẩm không được vượt quá 500 ký tự")
    private String name;
    
    private String description;
    
    private String notes;
    
    private String image;
    
    @NotNull(message = "Danh mục sản phẩm không được để trống")
    private Long idCategory;
    
    private String categoryName;
    
    private String contents;
    
    @NotNull(message = "Giá sản phẩm không được để trống")
    @Min(value = 0, message = "Giá sản phẩm không được âm")
    private BigDecimal price;
    
    @Min(value = 0, message = "Số lượng không được âm")
    private Integer quantity;
    
    @Size(max = 160, message = "Slug không được vượt quá 160 ký tự")
    private String slug;
    
    @Size(max = 100, message = "Meta title không được vượt quá 100 ký tự")
    private String metaTitle;
    
    @Size(max = 500, message = "Meta keyword không được vượt quá 500 ký tự")
    private String metaKeyword;
    
    @Size(max = 500, message = "Meta description không được vượt quá 500 ký tự")
    private String metaDescription;
    
    private LocalDateTime createdDate;
    
    private LocalDateTime updatedDate;
    
    private Long createdBy;
    
    private Long updatedBy;
    
    private Integer isDelete;
    
    private Integer isActive;
    
    private List<ProductImagesDTO> productImages;
    
    private List<ProductConfigDTO> productConfigs;
} 