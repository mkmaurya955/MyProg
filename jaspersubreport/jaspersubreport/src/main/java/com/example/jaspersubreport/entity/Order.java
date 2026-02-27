package com.example.jaspersubreport.entity;

import java.util.List;

public class Order {
	private Long orderId;
	private String customerName;
	private List<OrderItem> orderItems;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Order(Long orderId, String customerName, List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.orderItems = orderItems;
	}
	public Order(String customerName, List<OrderItem> orderItems) {
		super();
		this.customerName = customerName;
		this.orderItems = orderItems;
	}
	
	
}
