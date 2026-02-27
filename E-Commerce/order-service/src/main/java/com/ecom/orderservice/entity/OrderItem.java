package com.ecom.orderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ECOM_ORDER_ITEM")
@Getter
@Setter
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItemId;
	
	private Long orderId;
	
	private Long productId;
	
	private Integer quantity;
	
	private Double price;

}
