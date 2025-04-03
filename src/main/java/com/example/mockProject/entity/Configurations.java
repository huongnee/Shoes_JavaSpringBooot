package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "configurations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configurations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 500)
    private String name;
    
    @Column(name = "NOTES", columnDefinition = "text")
    private String notes;
    
    @Column(name = "ISDELETE")
    private Integer isDelete;
    
    @Column(name = "ISACTIVE")
    private Integer isActive;
} 