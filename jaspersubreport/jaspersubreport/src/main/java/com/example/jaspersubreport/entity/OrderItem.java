package com.example.jaspersubreport.entity;

public class OrderItem {
	private Long orderItemId;
	private String productName;
	private int quantity;
	private double price;

	public OrderItem(String productName, int quantity, double price) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItem(Long orderItemId, String productName, int quantity, double price) {
		super();
		this.orderItemId = orderItemId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
