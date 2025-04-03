package com.example.mockProject.repository;

import com.example.mockProject.entity.TransportMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransportMethodRepository extends JpaRepository<TransportMethod, Long> {
    
    Optional<TransportMethod> findByName(String name);
    
    List<TransportMethod> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete);
    
    @Query("SELECT tm FROM TransportMethod tm WHERE tm.isActive = 1 AND tm.isDelete = 0")
    List<TransportMethod> findAllActiveMethods();
    
    @Query("SELECT COUNT(o) FROM Orders o WHERE o.idTransport = :transportId")
    Long countOrdersByTransportMethod(@Param("transportId") Long transportId);
} 