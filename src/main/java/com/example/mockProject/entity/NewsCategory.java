package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "news_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 500)
    private String name;
    
    @Column(name = "NOTES", columnDefinition = "text")
    private String notes;
    
    @Column(name = "ICON", length = 250)
    private String icon;
    
    @Column(name = "IDPARENT")
    private Long idParent;
    
    @Column(name = "SLUG", length = 160)
    private String slug;
    
    @Column(name = "META_TITLE", length = 100)
    private String metaTitle;
    
    @Column(name = "META_KEYWORD", length = 500)
    private String metaKeyword;
    
    @Column(name = "META_DESCRIPTION", length = 300)
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
    
    @OneToMany(mappedBy = "newsCategory")
    private List<News> newsList;
} 