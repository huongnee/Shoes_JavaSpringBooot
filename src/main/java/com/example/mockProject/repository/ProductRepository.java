package com.example.mockProject.repository;

import com.example.mockProject.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Optional<Product> findBySlug(String slug);
    
    List<Product> findByIdCategory(Long idCategory);
    
    Page<Product> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete, Pageable pageable);
    
    @Query("SELECT p FROM Product p WHERE p.isActive = 1 AND p.isDelete = 0 ORDER BY p.createdDate DESC")
    Page<Product> findLatestProducts(Pageable pageable);
    
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice AND p.isActive = 1 AND p.isDelete = 0")
    Page<Product> findByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice, Pageable pageable);
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword% OR p.description LIKE %:keyword% OR p.metaKeyword LIKE %:keyword% AND p.isActive = 1 AND p.isDelete = 0")
    Page<Product> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
    
    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.slug = :categorySlug AND p.isActive = 1 AND p.isDelete = 0")
    Page<Product> findByCategorySlug(@Param("categorySlug") String categorySlug, Pageable pageable);
    
    @Query("SELECT p FROM Product p WHERE p.quantity > 0 AND p.isActive = 1 AND p.isDelete = 0")
    Page<Product> findProductsInStock(Pageable pageable);
    
    @Query("SELECT p FROM Product p WHERE p.quantity <= :threshold AND p.isActive = 1 AND p.isDelete = 0")
    List<Product> findProductsLowStock(@Param("threshold") Integer threshold);
} 