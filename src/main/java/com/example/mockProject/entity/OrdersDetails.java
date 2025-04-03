package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "orders_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "IDORD", nullable = false)
    private Long idOrd;
    
    @ManyToOne
    @JoinColumn(name = "IDORD", insertable = false, updatable = false)
    private Orders orders;
    
    @Column(name = "IDPRODUCT", nullable = false)
    private Long idProduct;
    
    @ManyToOne
    @JoinColumn(name = "IDPRODUCT", insertable = false, updatable = false)
    private Product product;
    
    @Column(name = "PRICE", nullable = false, precision = 10, scale = 0)
    private BigDecimal price;
    
    @Column(name = "QTY", nullable = false)
    private Integer qty;
    
    @Column(name = "TOTAL", nullable = false, precision = 10, scale = 0)
    private BigDecimal total;
    
    @Column(name = "RETURN_QTY")
    private Integer returnQty;
} 