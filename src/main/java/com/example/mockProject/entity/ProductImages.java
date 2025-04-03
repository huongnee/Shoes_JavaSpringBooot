package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImages {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 250)
    private String name;
    
    @Column(name = "URLIMG", length = 250)
    private String urlImg;
    
    @Column(name = "IDPRODUCT", nullable = false)
    private Long idProduct;
    
    @ManyToOne
    @JoinColumn(name = "IDPRODUCT", insertable = false, updatable = false)
    private Product product;
} 