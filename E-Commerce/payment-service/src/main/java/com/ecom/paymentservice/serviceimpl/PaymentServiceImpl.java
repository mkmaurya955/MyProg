package com.ecom.paymentservice.serviceimpl;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.paymentservice.dto.PaymentRequestDto;
import com.ecom.paymentservice.dto.PaymentResponseDto;
import com.ecom.paymentservice.entity.Payment;
import com.ecom.paymentservice.helper.OrderRestTemplate;
import com.ecom.paymentservice.helper.PaymentEnum;
import com.ecom.paymentservice.helper.PaymentResponseMapper;
import com.ecom.paymentservice.repository.PaymentRepository;
import com.ecom.paymentservice.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderRestTemplate orderRestTemplate;

	@Override
	public PaymentResponseDto createPayment(PaymentRequestDto paymentRequestDto) {
		
		Long orderId = paymentRequestDto.getOrderId();
		
		Payment payment = new Payment();
		payment.setCustomerId(paymentRequestDto.getCustomerId());
		payment.setOrderId(orderId);
		payment.setAmount(paymentRequestDto.getAmount());
		payment.setPaymentDate(LocalDateTime.now());
		boolean isPayment = new Random().nextBoolean();
		if(isPayment) {
			payment.setPaymentStatus(PaymentEnum.SUCCESS);
			orderRestTemplate.updateOrderStatus(orderId, "CONFIRMED");
			payment.setPaymentTrxId(generateTrxId());
		}else {
			payment.setPaymentStatus(PaymentEnum.FAILED);
			orderRestTemplate.updateOrderStatus(orderId, "CANCELLED");
			payment.setPaymentTrxId("NA");
		}
		Payment savedPayment = paymentRepository.save(payment);
		return PaymentResponseMapper.convertPaymentResponse(savedPayment);
	}

	@Override
	public PaymentResponseDto getOrderByOrderId(Long orderId) {
		Payment byOrderId = paymentRepository.findByOrderId(orderId);
		return PaymentResponseMapper.convertPaymentResponse(byOrderId);
	}

	public String generateTrxId() {
		return "TRX"+UUID.randomUUID().toString().substring(0, 8);
	}
}
