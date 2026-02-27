package com.ecom.orderservice.service;

import java.util.List;

import com.ecom.orderservice.dto.OrderRequestDto;
import com.ecom.orderservice.dto.OrderResponseDto;

public interface OrderService {

	OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
	
	List<OrderResponseDto> findByCustmerId(String id);
	
	OrderResponseDto findByOrderId(Long orderId);
	
	String updateOrderStatus(Long orderId, String status);
}
