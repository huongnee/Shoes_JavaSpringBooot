package com.example.mockProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {
    
    private Long id;
    
    @NotBlank(message = "Mã đơn hàng không được để trống")
    @Size(max = 10, message = "Mã đơn hàng không được vượt quá 10 ký tự")
    private String iOrders;
    
    @NotNull(message = "Ngày đặt hàng không được để trống")
    private LocalDateTime ordersDate;
    
    @NotNull(message = "ID khách hàng không được để trống")
    private Long idCustomer;
    
    private String customerName;
    
    @NotNull(message = "Phương thức thanh toán không được để trống")
    private Long idPayment;
    
    @NotNull(message = "Phương thức vận chuyển không được để trống")
    private Long idTransport;
    
    private String transportMethodName;
    
    @NotNull(message = "Tổng tiền không được để trống")
    private BigDecimal totalMoney;
    
    private String notes;
    
    @NotBlank(message = "Tên người nhận không được để trống")
    @Size(max = 250, message = "Tên người nhận không được vượt quá 250 ký tự")
    private String nameReceiver;
    
    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 500, message = "Địa chỉ không được vượt quá 500 ký tự")
    private String address;
    
    @Size(max = 150, message = "Email không được vượt quá 150 ký tự")
    private String email;
    
    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(max = 50, message = "Số điện thoại không được vượt quá 50 ký tự")
    private String phone;
    
    private Integer isDelete;
    
    private Integer isActive;
    
    private List<OrdersDetailsDTO> orderDetails;
} 