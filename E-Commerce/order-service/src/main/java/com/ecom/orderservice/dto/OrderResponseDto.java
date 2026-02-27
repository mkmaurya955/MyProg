package com.ecom.orderservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

	private Long orderId;
	private String customerId;
	private LocalDateTime orderDate;
	private Double totalAmt;
	private String status;
	private List<OrderItemDto> items;

}
