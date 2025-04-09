package com.example.mockProject.service;

import com.example.mockProject.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface UserService {
    
    List<UserDTO> findAll();
    
    Optional<UserDTO> findById(Long id);
    
    UserDTO save(UserDTO userDTO);
    
    UserDTO update(UserDTO userDTO);
    
    void delete(Long id);
    
    Optional<UserDTO> findByEmail(String email);
    
    Optional<UserDTO> findByUsername(String username);
    
    List<UserDTO> findByRole(String role);
    
    List<UserDTO> findByStatus(String status);
    
    Page<UserDTO> findAll(Pageable pageable);
    
    Page<UserDTO> findByRole(String role, Pageable pageable);
    
    Page<UserDTO> findByStatus(String status, Pageable pageable);
    
    Page<UserDTO> searchByKeyword(String keyword, Pageable pageable);
    
    List<UserDTO> findUsersByOrderStatus(String status);
    
    List<UserDTO> findUsersByProductCategory(String category);
    
    List<UserDTO> findUsersByOrderDateRange(LocalDateTime startDate, LocalDateTime endDate);
    
    List<UserDTO> findUsersByTotalAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
    
    List<UserDTO> findUsersByProductPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
} 