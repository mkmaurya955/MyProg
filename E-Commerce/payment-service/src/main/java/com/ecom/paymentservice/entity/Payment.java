package com.ecom.paymentservice.entity;

import java.time.LocalDateTime;

import com.ecom.paymentservice.helper.PaymentEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "ECOM_PAYMENT")
@Getter
@Setter
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	
	private Long orderId;
	
	private String customerId;
	
	private Double amount;
	
	private LocalDateTime paymentDate;
	
	private PaymentEnum paymentStatus;
	
	private String paymentTrxId;
	
}
