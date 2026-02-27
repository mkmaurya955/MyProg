package com.ecom.orderservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.ecom.orderservice.dto.OrderItemDto;
import com.ecom.orderservice.dto.OrderResponseDto;
import com.ecom.orderservice.dto.OrderStatus;
import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.entity.OrderItem;

public class OrderResponseMapper {

	public static OrderResponseDto convertOrderResponse(Order order, List<OrderItem> items) {
		OrderStatus status = order.getStatus();
		String orderStatus = status.toString();
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		orderResponseDto.setCustomerId(order.getCustomerId());
		orderResponseDto.setOrderId(order.getOrderId());
		orderResponseDto.setOrderDate(order.getOrderDate());
		orderResponseDto.setStatus(orderStatus);
		orderResponseDto.setTotalAmt(order.getTotalAmt());

		List<OrderItemDto> collectedList = items.stream().map(e -> {
			OrderItemDto orderItemDto = new OrderItemDto();
			orderItemDto.setOrderItemId(e.getOrderItemId());
			orderItemDto.setOrderId(e.getOrderId());
			orderItemDto.setProductId(e.getProductId());
			orderItemDto.setQuantity(e.getQuantity());
			orderItemDto.setPrice(e.getPrice());
			return orderItemDto;
		}).collect(Collectors.toList());

		orderResponseDto.setItems(collectedList);

		return orderResponseDto;

	}

}
