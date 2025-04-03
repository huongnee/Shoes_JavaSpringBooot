package com.example.mockProject.repository;

import com.example.mockProject.entity.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigurationsRepository extends JpaRepository<Configurations, Long> {
    
    Optional<Configurations> findByName(String name);
    
    List<Configurations> findByIsActiveAndIsDelete(Integer isActive, Integer isDelete);
    
    @Query("SELECT c FROM Configurations c WHERE c.isActive = 1 AND c.isDelete = 0")
    List<Configurations> findAllActiveConfigurations();
} 