package com.example.mockProject.service;

import com.example.mockProject.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    
    List<CategoryDTO> findAll();
    
    Optional<CategoryDTO> findById(Long id);
    
    CategoryDTO save(CategoryDTO categoryDTO);
    
    CategoryDTO update(CategoryDTO categoryDTO);
    
    void delete(Long id);
    
    Optional<CategoryDTO> findByName(String name);
    
    Page<CategoryDTO> findAll(Pageable pageable);
    
    List<CategoryDTO> findByIdParent(Long idParent);
    
    List<CategoryDTO> findByIdParentIsNull();
    
    List<CategoryDTO> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete);
    
    boolean existsByName(String name);
    
    Page<CategoryDTO> searchByKeyword(String keyword, Pageable pageable);
    
    List<CategoryDTO> findActiveCategories(Pageable pageable);
    
    Long countProductsByCategory(Long categoryId);
} 