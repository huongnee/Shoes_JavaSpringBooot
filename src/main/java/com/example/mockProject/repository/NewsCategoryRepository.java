package com.example.mockProject.repository;

import com.example.mockProject.entity.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsCategoryRepository extends JpaRepository<NewsCategory, Long> {
    
    Optional<NewsCategory> findBySlug(String slug);
    
    List<NewsCategory> findByIdParent(Long idParent);
    
    List<NewsCategory> findByIdParentIsNull();
    
    List<NewsCategory> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete);
    
    @Query("SELECT nc FROM NewsCategory nc WHERE nc.isActive = 1 AND nc.isDelete = 0")
    List<NewsCategory> findAllActiveCategories();
    
    @Query("SELECT COUNT(n) FROM News n WHERE n.idNewsCategory = :categoryId")
    Long countNewsByCategory(@Param("categoryId") Long categoryId);
} 