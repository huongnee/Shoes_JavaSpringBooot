package com.example.mockProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    
    private Long id;
    
    @NotBlank(message = "Tên không được để trống")
    @Size(max = 250, message = "Tên không được vượt quá 250 ký tự")
    private String name;
    
    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Size(min = 4, max = 50, message = "Tên đăng nhập phải từ 4-50 ký tự")
    private String username;
    
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    private String password;
    
    @Size(max = 500, message = "Địa chỉ không được vượt quá 500 ký tự")
    private String address;
    
    @Email(message = "Email không hợp lệ")
    @Size(max = 150, message = "Email không được vượt quá 150 ký tự")
    private String email;
    
    @Size(max = 50, message = "Số điện thoại không được vượt quá 50 ký tự")
    private String phone;
    
    private String avatar;
    
    private LocalDateTime createdDate;
    
    private LocalDateTime updatedDate;
    
    private Long createdBy;
    
    private Long updatedBy;
    
    private Integer isDelete;
    
    private Integer isActive;
    
    private Long orderCount;
} 