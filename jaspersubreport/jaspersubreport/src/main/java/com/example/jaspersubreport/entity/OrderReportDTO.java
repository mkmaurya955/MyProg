package com.example.jaspersubreport.entity;

import java.util.List;

public class OrderReportDTO {
	private String customerName;
	private List<OrderItemReportDTO> orderItems;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<OrderItemReportDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemReportDTO> orderItems) {
		this.orderItems = orderItems;
	}

}
