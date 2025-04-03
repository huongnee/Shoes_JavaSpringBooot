package com.example.mockProject.repository;

import com.example.mockProject.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    
    List<ProductImages> findByIdProduct(Long idProduct);
    
    void deleteByIdProduct(Long idProduct);
    
    @Query("SELECT pi FROM ProductImages pi WHERE pi.idProduct = :productId ORDER BY pi.id ASC")
    List<ProductImages> findProductImagesOrdered(@Param("productId") Long productId);
    
    @Query("SELECT COUNT(pi) FROM ProductImages pi WHERE pi.idProduct = :productId")
    Long countImagesByProduct(@Param("productId") Long productId);
} 