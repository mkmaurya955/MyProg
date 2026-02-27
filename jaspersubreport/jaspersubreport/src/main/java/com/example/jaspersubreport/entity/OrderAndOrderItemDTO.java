package com.example.jaspersubreport.entity;

public class OrderAndOrderItemDTO {
	private String customerName;
	private String productName;
	private int quantity;
	private double price;
	
	public OrderAndOrderItemDTO(String customerName, String productName, int quantity, double price) {
		super();
		this.customerName = customerName;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public OrderAndOrderItemDTO() {
		super();
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
