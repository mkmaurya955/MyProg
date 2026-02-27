package com.ecom.orderservice.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ecom.orderservice.dto.ItemDto;
import com.ecom.orderservice.dto.OrderRequestDto;
import com.ecom.orderservice.dto.OrderResponseDto;
import com.ecom.orderservice.dto.OrderStatus;
import com.ecom.orderservice.dto.ProductResponseDto;
import com.ecom.orderservice.entity.Order;
import com.ecom.orderservice.entity.OrderItem;
import com.ecom.orderservice.helper.ProductRestTemplate;
import com.ecom.orderservice.mapper.OrderResponseMapper;
import com.ecom.orderservice.repository.OrderItemRepository;
import com.ecom.orderservice.repository.OrderRepository;
import com.ecom.orderservice.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductRestTemplate productRestTemplate;

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

		List<OrderItem> items = new ArrayList<>();
		Double totalAmt = 0.0;
		Order savedOrder = null;
		for (ItemDto itemDto : orderRequestDto.getItems()) {
			Long productId = itemDto.getProductId();
			Integer quantity = itemDto.getQuantity();

			ProductResponseDto productById = productRestTemplate.getProductById(productId);

			String updateProductQuantity = productRestTemplate.updateProductQuantity(productId, quantity);
			
			System.out.println(updateProductQuantity);

			Double price = productById.getPrice();

			totalAmt = price * quantity;

			Order order = new Order();
			order.setCustomerId(orderRequestDto.getCustomerId());
			order.setOrderDate(LocalDateTime.now());
			order.setStatus(OrderStatus.PENDING);
			order.setTotalAmt(totalAmt);
			savedOrder = orderRepository.save(order);

			OrderItem item = new OrderItem();
			item.setOrderId(savedOrder.getOrderId());
			item.setPrice(price);
			item.setProductId(productId);
			item.setQuantity(quantity);
			items.add(item);
		}

		List<OrderItem> saveAllItems = orderItemRepository.saveAll(items);

		OrderResponseDto orderResponse = OrderResponseMapper.convertOrderResponse(savedOrder, saveAllItems);
		return orderResponse;

	}

	@Override
	public List<OrderResponseDto> findByCustmerId(String customerId) {
		List<Order> byCustomerId = orderRepository.findByCustomerId(customerId);
		List<OrderResponseDto> collect = null;
		if (!CollectionUtils.isEmpty(byCustomerId)) {
			collect = byCustomerId.stream().map(e->{
				Long orderId = e.getOrderId();
				Order order = new Order();
				order.setCustomerId(e.getCustomerId());
				order.setOrderDate(e.getOrderDate());
				order.setOrderId(orderId);
				order.setStatus(e.getStatus());
				order.setTotalAmt(e.getTotalAmt());
				List<OrderItem> byOrderId = orderItemRepository.findByOrderId(orderId);
				OrderResponseDto convertOrderResponse = OrderResponseMapper.convertOrderResponse(order, byOrderId);
				return convertOrderResponse;
			}).collect(Collectors.toList());
			
		}
		
		return collect;
	}

	@Override
	public OrderResponseDto findByOrderId(Long orderId) {
		List<OrderItem> orderItems = null;
		Optional<Order> byOrderId = orderRepository.findByOrderId(orderId);
		if (byOrderId.isPresent()) {
			orderItems = orderItemRepository.findByOrderId(orderId);
		}
		OrderResponseDto convertOrderResponse = OrderResponseMapper.convertOrderResponse(byOrderId.get(), orderItems);
		return convertOrderResponse;
	}

	@Override
	public String updateOrderStatus(Long orderId,String status) {
		Optional<Order> byOrderId = orderRepository.findByOrderId(orderId);
		if (byOrderId.isPresent()) {
			Order order = byOrderId.get();
			order.setStatus(OrderStatus.valueOf(status));
			orderRepository.save(order);
		}
		return "You Order Status is updated..!!";
	}

}
