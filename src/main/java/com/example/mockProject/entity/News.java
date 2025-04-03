package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "news")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 500)
    private String name;
    
    @Column(name = "DESCRIPTION", columnDefinition = "text")
    private String description;
    
    @Column(name = "IMAGE", length = 550)
    private String image;
    
    @Column(name = "IDNEWSCATEGORY", nullable = false)
    private Long idNewsCategory;
    
    @ManyToOne
    @JoinColumn(name = "IDNEWSCATEGORY", insertable = false, updatable = false)
    private NewsCategory newsCategory;
    
    @Column(name = "CONTENTS", columnDefinition = "text")
    private String contents;
    
    @Column(name = "SLUG", length = 160)
    private String slug;
    
    @Column(name = "META_TITLE", length = 100)
    private String metaTitle;
    
    @Column(name = "META_KEYWORD", length = 500)
    private String metaKeyword;
    
    @Column(name = "META_DESCRIPTION", length = 500)
    private String metaDescription;
    
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
    
    @Column(name = "CREATED_BY")
    private Long createdBy;
    
    @Column(name = "UPDATED_BY")
    private Long updatedBy;
    
    @Column(name = "ISDELETE")
    private Integer isDelete;
    
    @Column(name = "ISACTIVE")
    private Integer isActive;
} 