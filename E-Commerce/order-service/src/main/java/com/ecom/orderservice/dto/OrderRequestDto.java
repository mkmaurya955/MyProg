package com.ecom.orderservice.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequestDto {
	private String customerId;

	private List<ItemDto> items;
}
