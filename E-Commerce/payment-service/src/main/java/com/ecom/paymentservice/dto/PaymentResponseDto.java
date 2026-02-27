package com.ecom.paymentservice.dto;

import java.time.LocalDateTime;

import com.ecom.paymentservice.helper.PaymentEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDto {

	private Long paymentId;

	private Long orderId;

	private String customerId;

	private Double amount;

	private LocalDateTime paymentDate;

	private PaymentEnum paymentStatus;

	private String paymentTrxId;

}
