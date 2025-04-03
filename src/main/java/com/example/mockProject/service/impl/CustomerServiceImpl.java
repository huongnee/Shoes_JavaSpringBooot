package com.example.mockProject.service.impl;

import com.example.mockProject.dto.LoginDTO;
import com.example.mockProject.dto.RegisterDTO;
import com.example.mockProject.dto.ResponseDTO;
import com.example.mockProject.entity.Customer;
import com.example.mockProject.repository.CustomerRepository;
import com.example.mockProject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseDTO<Customer> register(RegisterDTO registerDTO) {
        // Kiểm tra username đã tồn tại chưa
        if (customerRepository.existsByUsername(registerDTO.getUsername())) {
            return ResponseDTO.error("Tên đăng nhập đã tồn tại");
        }
        
        // Kiểm tra email đã tồn tại chưa
        if (customerRepository.existsByEmail(registerDTO.getEmail())) {
            return ResponseDTO.error("Email đã tồn tại");
        }
        
        // Tạo customer mới
        Customer customer = new Customer();
        customer.setName(registerDTO.getName());
        customer.setUsername(registerDTO.getUsername());
        customer.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        customer.setAddress(registerDTO.getAddress());
        customer.setEmail(registerDTO.getEmail());
        customer.setPhone(registerDTO.getPhone());
        
        // Xử lý avatar
        if (registerDTO.getAvatar() != null && !registerDTO.getAvatar().isEmpty()) {
            customer.setAvatar(registerDTO.getAvatar());
        } else {
            customer.setAvatar("default-avatar.jpg"); // Avatar mặc định
        }
        
        // Xử lý người tạo
        if (registerDTO.getCreatedBy() != null) {
            customer.setCreatedBy(registerDTO.getCreatedBy());
        } else {
            customer.setCreatedBy(1L); // Mặc định admin ID là 1
        }
        
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUpdatedDate(LocalDateTime.now());
        customer.setUpdatedBy(customer.getCreatedBy()); // Người cập nhật ban đầu cũng là người tạo
        customer.setIsDelete(0);
        customer.setIsActive(1);
        
        // Lưu customer
        Customer savedCustomer = customerRepository.save(customer);
        
        return ResponseDTO.success("Đăng ký thành công", savedCustomer);
    }

    @Override
    public ResponseDTO<Customer> login(LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsername(),
                    loginDTO.getPassword()
                )
            );
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            Customer customer = findByUsername(loginDTO.getUsername());
            return ResponseDTO.success("Đăng nhập thành công", customer);
        } catch (AuthenticationException e) {
            return ResponseDTO.error("Tên đăng nhập hoặc mật khẩu không đúng");
        }
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username)
            .orElse(null);
    }
} 