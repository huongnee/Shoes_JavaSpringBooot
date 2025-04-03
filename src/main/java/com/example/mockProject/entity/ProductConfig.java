package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfig {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "IDPRODUCT", nullable = false)
    private Long idProduct;
    
    @ManyToOne
    @JoinColumn(name = "IDPRODUCT", insertable = false, updatable = false)
    private Product product;
    
    @Column(name = "IDCONFIG", nullable = false)
    private Long idConfig;
    
    @ManyToOne
    @JoinColumn(name = "IDCONFIG", insertable = false, updatable = false)
    private Configurations config;
    
    @Column(name = "VALUE", columnDefinition = "text")
    private String value;
} 