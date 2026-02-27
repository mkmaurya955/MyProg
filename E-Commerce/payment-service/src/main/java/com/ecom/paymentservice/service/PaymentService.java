package com.ecom.paymentservice.service;

import com.ecom.paymentservice.dto.PaymentRequestDto;
import com.ecom.paymentservice.dto.PaymentResponseDto;

public interface PaymentService {
	
	PaymentResponseDto createPayment(PaymentRequestDto paymentRequestDto);
	
	PaymentResponseDto getOrderByOrderId(Long orderId);

}
