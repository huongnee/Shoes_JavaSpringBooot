package com.example.mockProject.repository;

import com.example.mockProject.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    
    Optional<News> findBySlug(String slug);
    
    List<News> findByIdNewsCategory(Long idNewsCategory);
    
    List<News> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete);
    
    @Query("SELECT n FROM News n WHERE n.isActive = 1 AND n.isDelete = 0 ORDER BY n.createdDate DESC")
    Page<News> findLatestNews(Pageable pageable);
    
    @Query("SELECT n FROM News n WHERE n.idNewsCategory = :categoryId AND n.isActive = 1 AND n.isDelete = 0")
    Page<News> findByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);
    
    @Query("SELECT n FROM News n WHERE (n.name LIKE %:keyword% OR n.description LIKE %:keyword% OR n.contents LIKE %:keyword%) AND n.isActive = 1 AND n.isDelete = 0")
    Page<News> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);
    
    @Query("SELECT n FROM News n JOIN n.newsCategory c WHERE c.slug = :categorySlug AND n.isActive = 1 AND n.isDelete = 0")
    Page<News> findByCategorySlug(@Param("categorySlug") String categorySlug, Pageable pageable);
} 