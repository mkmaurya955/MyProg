package com.ecom.orderservice.entity;

import java.time.LocalDateTime;

import com.ecom.orderservice.dto.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ECOM_ORDER")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private String customerId;
	private LocalDateTime orderDate;
	private Double totalAmt;
	private OrderStatus status;
}
