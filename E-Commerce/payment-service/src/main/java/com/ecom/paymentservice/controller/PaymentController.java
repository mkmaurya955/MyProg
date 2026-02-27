package com.ecom.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.paymentservice.dto.PaymentRequestDto;
import com.ecom.paymentservice.dto.PaymentResponseDto;
import com.ecom.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/createPayment")
	ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentRequestDto paymentRequestDto){
		PaymentResponseDto responseDto = paymentService.createPayment(paymentRequestDto);
		return ResponseEntity.ok(responseDto);
	}
	
	@GetMapping("/order/{id}")
	ResponseEntity<PaymentResponseDto> getPaymentDetailsByOrderId(@PathVariable Long id){
		PaymentResponseDto byOrderId = paymentService.getOrderByOrderId(id);
		return ResponseEntity.ok(byOrderId);
	}
	

}
