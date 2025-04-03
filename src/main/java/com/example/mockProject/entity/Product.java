package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 500)
    private String name;
    
    @Column(name = "DESCRIPTION", columnDefinition = "text")
    private String description;
    
    @Column(name = "NOTES", columnDefinition = "text")
    private String notes;
    
    @Column(name = "IMAGE", length = 550)
    private String image;
    
    @Column(name = "IDCATEGORY", nullable = false)
    private Long idCategory;
    
    @ManyToOne
    @JoinColumn(name = "IDCATEGORY", insertable = false, updatable = false)
    private Category category;
    
    @Column(name = "CONTENTS", columnDefinition = "text")
    private String contents;
    
    @Column(name = "PRICE", precision = 10, scale = 0)
    private BigDecimal price;
    
    @Column(name = "QUANTITY")
    private Integer quantity;
    
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
    
    @OneToMany(mappedBy = "product")
    private List<OrdersDetails> ordersDetailsList;
    
    @OneToMany(mappedBy = "product")
    private List<ProductConfig> productConfigList;
    
    @OneToMany(mappedBy = "product")
    private List<ProductImages> productImagesList;
} 