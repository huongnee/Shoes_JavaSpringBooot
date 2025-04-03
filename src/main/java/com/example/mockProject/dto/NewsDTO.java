package com.example.mockProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO {
    
    private Long id;
    
    @NotBlank(message = "Tiêu đề tin tức không được để trống")
    @Size(max = 500, message = "Tiêu đề tin tức không được vượt quá 500 ký tự")
    private String name;
    
    private String description;
    
    private String image;
    
    @NotNull(message = "Danh mục tin tức không được để trống")
    private Long idNewsCategory;
    
    private String newsCategoryName;
    
    private String contents;
    
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
} 