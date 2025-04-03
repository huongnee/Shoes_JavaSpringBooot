package com.example.mockProject.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDetailsDTO {
    
    private Long id;
    
    @NotNull(message = "ID đơn hàng không được để trống")
    private Long idOrd;
    
    @NotNull(message = "ID sản phẩm không được để trống")
    private Long idProduct;
    
    private String productName;
    
    private String productImage;
    
    @NotNull(message = "Giá không được để trống")
    @Min(value = 0, message = "Giá không được âm")
    private BigDecimal price;
    
    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng không được âm")
    private Integer qty;
    
    @NotNull(message = "Tổng tiền không được để trống")
    @Min(value = 0, message = "Tổng tiền không được âm")
    private BigDecimal total;
    
    private Integer returnQty;
} 