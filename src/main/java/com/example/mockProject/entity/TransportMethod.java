package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transport_method")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportMethod {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME", length = 250)
    private String name;
    
    @Column(name = "NOTES", columnDefinition = "text")
    private String notes;
    
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;
    
    @Column(name = "ISDELETE")
    private Integer isDelete;
    
    @Column(name = "ISACTIVE")
    private Integer isActive;
    
    @OneToMany(mappedBy = "transportMethod")
    private List<Orders> ordersList;
} 