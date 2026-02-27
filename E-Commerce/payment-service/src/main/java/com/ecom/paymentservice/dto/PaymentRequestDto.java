package com.ecom.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
	
	private Long orderId;
	
	private String customerId;
	
	private Double amount;

}
