package com.example.mockProject.service;

import com.example.mockProject.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    
    List<ProductDTO> findAll();
    
    Optional<ProductDTO> findById(Long id);
    
    ProductDTO save(ProductDTO productDTO);
    
    ProductDTO update(ProductDTO productDTO);
    
    void delete(Long id);
    
    List<ProductDTO> findByCategory(String category);
    
    List<ProductDTO> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    
    List<ProductDTO> findByStockQuantity(int quantity);
    
    Page<ProductDTO> findAll(Pageable pageable);
    
    Page<ProductDTO> findByCategory(String category, Pageable pageable);
    
    Page<ProductDTO> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    
    Page<ProductDTO> findByStockQuantity(int quantity, Pageable pageable);
    
    Page<ProductDTO> findTopSellingProducts(Pageable pageable);
    
    Page<ProductDTO> searchByKeyword(String keyword, Pageable pageable);
    
    List<ProductDTO> findProductsByOrderStatus(String status);
    
    List<ProductDTO> findProductsByUserEmail(String email);
    
    List<ProductDTO> findProductsByOrderDateRange(LocalDateTime startDate, LocalDateTime endDate);
    
    List<ProductDTO> findProductsByTotalAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
} 