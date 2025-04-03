package com.example.mockProject.repository;

import com.example.mockProject.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    Optional<Category> findBySlug(String slug);
    
    List<Category> findByIdParent(Long idParent);
    
    List<Category> findByIdParentIsNull();
    
    List<Category> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete);
    
    boolean existsByName(String name);
    
    @Query("SELECT c FROM Category c WHERE c.name LIKE %:keyword% OR c.metaKeyword LIKE %:keyword% OR c.metaDescription LIKE %:keyword%")
    Page<Category> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
    
    @Query("SELECT c FROM Category c WHERE c.isActive = 1 AND c.isDelete = 0 ORDER BY c.createdDate DESC")
    List<Category> findActiveCategories(Pageable pageable);
    
    @Query("SELECT COUNT(p) FROM Product p WHERE p.idCategory = :categoryId")
    Long countProductsByCategory(@Param("categoryId") Long categoryId);
} 