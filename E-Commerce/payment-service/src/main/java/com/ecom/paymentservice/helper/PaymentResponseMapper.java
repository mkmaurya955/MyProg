package com.ecom.paymentservice.helper;

import com.ecom.paymentservice.dto.PaymentResponseDto;
import com.ecom.paymentservice.entity.Payment;

public class PaymentResponseMapper {
	
	public static PaymentResponseDto convertPaymentResponse(Payment payment) {
		PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
		paymentResponseDto.setCustomerId(payment.getCustomerId());
		paymentResponseDto.setAmount(payment.getAmount());
		paymentResponseDto.setOrderId(payment.getOrderId());
		paymentResponseDto.setPaymentDate(payment.getPaymentDate());
		paymentResponseDto.setPaymentId(payment.getPaymentId());
		paymentResponseDto.setPaymentStatus(payment.getPaymentStatus());
		paymentResponseDto.setPaymentTrxId(payment.getPaymentTrxId());
		return paymentResponseDto;
	}

}
