package com.example.mockProject.service;

import com.example.mockProject.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    
    List<OrderDTO> findAll();
    
    Optional<OrderDTO> findById(Long id);
    
    OrderDTO save(OrderDTO orderDTO);
    
    OrderDTO update(OrderDTO orderDTO);
    
    void delete(Long id);
    
    List<OrderDTO> findByUserId(Long userId);
    
    Page<OrderDTO> findAll(Pageable pageable);
    
    Page<OrderDTO> findByStatus(String status, Pageable pageable);
    
    Page<OrderDTO> findByDateRange(String startDate, String endDate, Pageable pageable);
    
    Page<OrderDTO> findByTotalAmountRange(BigDecimal minAmount, BigDecimal maxAmount, Pageable pageable);
    
    Page<OrderDTO> findLatestOrders(Pageable pageable);
    
    Page<OrderDTO> searchByKeyword(String keyword, Pageable pageable);
    
    List<OrderDTO> findOrdersByUserEmail(String email);
    
    Page<OrderDTO> findOrdersByPaymentMethod(String paymentMethod, Pageable pageable);
    
    List<OrderDTO> findOrdersByProductId(Long productId);
    
    Page<OrderDTO> findOrdersByShippingStatus(String shippingStatus, Pageable pageable);
} 