package com.example.mockProject.repository;

import com.example.mockProject.entity.ProductConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductConfigRepository extends JpaRepository<ProductConfig, Long> {
    
    List<ProductConfig> findByIdProduct(Long idProduct);
    
    List<ProductConfig> findByIdConfig(Long idConfig);
    
    void deleteByIdProduct(Long idProduct);
    
    @Query("SELECT pc FROM ProductConfig pc WHERE pc.idProduct = :productId AND pc.idConfig = :configId")
    List<ProductConfig> findByProductAndConfig(@Param("productId") Long productId, @Param("configId") Long configId);
    
    @Query("SELECT pc FROM ProductConfig pc JOIN pc.config c WHERE pc.idProduct = :productId AND c.isActive = 1 AND c.isDelete = 0")
    List<ProductConfig> findActiveConfigsByProduct(@Param("productId") Long productId);
} 