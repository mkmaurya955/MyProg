package com.example.manytomanymapping.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "JPA_PRODUCT")

public class Product {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String productName;

	private String productValue;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "category_product")
	@JsonBackReference
	private List<Category> category = new ArrayList<>();

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

	public String getProductValue() {
		return productValue;
	}

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productValue=" + productValue + ", category="
				+ category + "]";
	}

	public Product(Long id, String productName, String productValue, List<Category> category) {
		super();
		this.id = id;
		this.productName = productName;
		this.productValue = productValue;
		this.category = category;
	}

	public Product() {
		super();
	}

}
