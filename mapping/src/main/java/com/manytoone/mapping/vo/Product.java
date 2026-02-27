package com.manytoone.mapping.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")

public class Product implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private double price;

    private int qty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	public Product(Long id, String productName, double price, int qty, Customer customer) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
//		this.customer = customer;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", qty=" + qty
				+ "]";
	}
    
    
}
