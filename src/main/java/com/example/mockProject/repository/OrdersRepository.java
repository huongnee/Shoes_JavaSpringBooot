package com.example.mockProject.repository;

import com.example.mockProject.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    
    Optional<Orders> findByiOrders(String iOrders);
    
    List<Orders> findByIdCustomer(Long idCustomer);
    
    List<Orders> findByIdTransport(Long idTransport);
    
    @Query("SELECT o FROM Orders o WHERE o.ordersDate BETWEEN :startDate AND :endDate")
    List<Orders> findByOrdersDateBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT o FROM Orders o WHERE o.idCustomer = :customerId ORDER BY o.ordersDate DESC")
    Page<Orders> findCustomerOrdersWithPagination(@Param("customerId") Long customerId, Pageable pageable);
    
    @Query("SELECT SUM(o.totalMoney) FROM Orders o WHERE o.ordersDate BETWEEN :startDate AND :endDate")
    Double getTotalSalesBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT COUNT(o) FROM Orders o WHERE o.idCustomer = :customerId")
    Long countOrdersByCustomer(@Param("customerId") Long customerId);
    
    @Query("SELECT o FROM Orders o WHERE o.nameReceiver LIKE %:keyword% OR o.phone LIKE %:keyword% OR o.iOrders LIKE %:keyword%")
    Page<Orders> searchOrders(@Param("keyword") String keyword, Pageable pageable);
} 