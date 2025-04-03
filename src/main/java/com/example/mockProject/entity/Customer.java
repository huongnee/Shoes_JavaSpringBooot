package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 250)
    private String name;
    
    @Column(name = "USERNAME", length = 50, nullable = false)
    private String username;
    
    @Column(name = "PASSWORD", length = 500, nullable = false)
    private String password;
    
    @Column(name = "ADDRESS", length = 500)
    private String address;
    
    @Column(name = "EMAIL", length = 150)
    private String email;
    
    @Column(name = "PHONE", length = 50)
    private String phone;
    
    @Column(name = "AVATAR", length = 250)
    private String avatar;
    
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