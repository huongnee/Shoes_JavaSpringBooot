package com.example.mockProject.service;

import com.example.mockProject.dto.ConfigurationsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ConfigurationsService {
    
    List<ConfigurationsDTO> findAll();
    
    Optional<ConfigurationsDTO> findById(Long id);
    
    ConfigurationsDTO save(ConfigurationsDTO configurationsDTO);
    
    ConfigurationsDTO update(ConfigurationsDTO configurationsDTO);
    
    void delete(Long id);
    
    Optional<ConfigurationsDTO> findByName(String name);
    
    Page<ConfigurationsDTO> findAll(Pageable pageable);
    
    List<ConfigurationsDTO> findByIdProduct(Long idProduct);
    
    Page<ConfigurationsDTO> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete, Pageable pageable);
    
    Page<ConfigurationsDTO> findLatestConfigurations(Pageable pageable);
    
    Page<ConfigurationsDTO> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    
    Page<ConfigurationsDTO> searchByKeyword(String keyword, Pageable pageable);
    
    Page<ConfigurationsDTO> findByProductSlug(String productSlug, Pageable pageable);
    
    Page<ConfigurationsDTO> findConfigurationsInStock(Pageable pageable);
    
    List<ConfigurationsDTO> findConfigurationsLowStock(Integer threshold);
} 