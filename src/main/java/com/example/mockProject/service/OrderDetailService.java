package com.example.mockProject.service;

import com.example.mockProject.dto.OrderDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    
    List<OrderDetailDTO> findAll();
    
    Optional<OrderDetailDTO> findById(Long id);
    
    OrderDetailDTO save(OrderDetailDTO orderDetailDTO);
    
    OrderDetailDTO update(OrderDetailDTO orderDetailDTO);
    
    void delete(Long id);
    
    List<OrderDetailDTO> findByOrderId(Long orderId);
    
    List<OrderDetailDTO> findByProductId(Long productId);
    
    Page<OrderDetailDTO> findAll(Pageable pageable);
    
    Page<OrderDetailDTO> findByOrderId(Long orderId, Pageable pageable);
    
    Page<OrderDetailDTO> findByProductId(Long productId, Pageable pageable);
    
    Page<OrderDetailDTO> findByQuantityRange(int minQuantity, int maxQuantity, Pageable pageable);
    
    Page<OrderDetailDTO> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    
    Page<OrderDetailDTO> findTopSellingProducts(Pageable pageable);
    
    Page<OrderDetailDTO> searchByKeyword(String keyword, Pageable pageable);
    
    List<OrderDetailDTO> findOrderDetailsByOrderStatus(String status);
    
    Page<OrderDetailDTO> findOrderDetailsByProductCategory(String category, Pageable pageable);
    
    List<OrderDetailDTO> findOrderDetailsByUserEmail(String email);
} 