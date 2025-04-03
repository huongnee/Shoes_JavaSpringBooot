package com.example.mockProject.controller;

import com.example.mockProject.dto.LoginDTO;
import com.example.mockProject.dto.RegisterDTO;
import com.example.mockProject.dto.ResponseDTO;
import com.example.mockProject.entity.Customer;
import com.example.mockProject.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<Customer>> register(@Valid @RequestBody RegisterDTO registerDTO) {
        ResponseDTO<Customer> response = customerService.register(registerDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<Customer>> login(@Valid @RequestBody LoginDTO loginDTO) {
        ResponseDTO<Customer> response = customerService.login(loginDTO);
        return ResponseEntity.ok(response);
    }
} 