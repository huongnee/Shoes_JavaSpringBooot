package com.example.mockProject.service;

import com.example.mockProject.dto.LoginDTO;
import com.example.mockProject.dto.RegisterDTO;
import com.example.mockProject.dto.ResponseDTO;
import com.example.mockProject.entity.Customer;

public interface CustomerService {
    
    ResponseDTO<Customer> register(RegisterDTO registerDTO);
    
    ResponseDTO<Customer> login(LoginDTO loginDTO);
    
    Customer findByUsername(String username);
} 