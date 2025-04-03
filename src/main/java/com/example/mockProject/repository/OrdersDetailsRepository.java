package com.example.mockProject.repository;

import com.example.mockProject.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrdersDetails, Long> {
    
    List<OrdersDetails> findByIdOrd(Long idOrd);
    
    List<OrdersDetails> findByIdProduct(Long idProduct);
    
    @Query("SELECT od FROM OrdersDetails od WHERE od.idOrd = :orderId")
    List<OrdersDetails> findOrderDetailsByOrderId(@Param("orderId") Long orderId);
    
    @Query("SELECT SUM(od.total) FROM OrdersDetails od WHERE od.idOrd = :orderId")
    Double calculateOrderTotal(@Param("orderId") Long orderId);
    
    @Query("SELECT SUM(od.qty) FROM OrdersDetails od WHERE od.idProduct = :productId")
    Integer getTotalQuantitySoldByProduct(@Param("productId") Long productId);
    
    @Query("SELECT od.idProduct, SUM(od.qty) as totalQty FROM OrdersDetails od GROUP BY od.idProduct ORDER BY totalQty DESC")
    List<Object[]> findTopSellingProducts(Pageable pageable);
} 