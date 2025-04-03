package com.example.mockProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "IORDERS", length = 10, nullable = false)
    private String iOrders;
    
    @Column(name = "ORDERS_DATE", nullable = false)
    private LocalDateTime ordersDate;
    
    @Column(name = "IDCUSTOMER", nullable = false)
    private Long idCustomer;
    
    @ManyToOne
    @JoinColumn(name = "IDCUSTOMER", insertable = false, updatable = false)
    private Customer customer;
    
    @Column(name = "IDPAYMENT", nullable = false)
    private Long idPayment;
    
    @Column(name = "IDTRANSPORT", nullable = false)
    private Long idTransport;
    
    @ManyToOne
    @JoinColumn(name = "IDTRANSPORT", insertable = false, updatable = false)
    private TransportMethod transportMethod;
    
    @Column(name = "TOTAL_MONEY", nullable = false, precision = 10, scale = 0)
    private BigDecimal totalMoney;
    
    @Column(name = "NOTES", columnDefinition = "text")
    private String notes;
    
    @Column(name = "NAME_RECEIVER", length = 250)
    private String nameReceiver;
    
    @Column(name = "ADDRESS", length = 500)
    private String address;
    
    @Column(name = "EMAIL", length = 150)
    private String email;
    
    @Column(name = "PHONE", length = 50)
    private String phone;
    
    @Column(name = "ISDELETE")
    private Integer isDelete;
    
    @Column(name = "ISACTIVE")
    private Integer isActive;
    
    @OneToMany(mappedBy = "orders")
    private List<OrdersDetails> ordersDetailsList;
} 