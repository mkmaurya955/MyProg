package com.ecom.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.orderservice.dto.OrderRequestDto;
import com.ecom.orderservice.dto.OrderResponseDto;
import com.ecom.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/createOrder")
	ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){
		OrderResponseDto order = orderService.createOrder(orderRequestDto);
		return ResponseEntity.ok(order);
	}
	
	@PostMapping("orderById/{id}")
	ResponseEntity<OrderResponseDto> getOrderByOrderId(@PathVariable("id") Long id){
		OrderResponseDto byOrderId = orderService.findByOrderId(id);
		return ResponseEntity.ok(byOrderId);
	}
	
	@PostMapping("customerById/{id}")
	ResponseEntity<List<OrderResponseDto>> getOrderByCustomerId(@PathVariable("id") String id){
		List<OrderResponseDto> byOrderId = orderService.findByCustmerId(id);
		return ResponseEntity.ok(byOrderId);
	}
	
	@GetMapping("updateOrderStatus/{id}/orderStatus/{status}")
	ResponseEntity<String> getUpdateOrderStatus(@PathVariable("id") Long id, @PathVariable("status") String status){
		String byOrderId = orderService.updateOrderStatus(id,status);
		return ResponseEntity.ok(byOrderId);
	}

}
