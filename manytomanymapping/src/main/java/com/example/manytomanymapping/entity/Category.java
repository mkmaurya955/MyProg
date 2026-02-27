package com.example.manytomanymapping.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "JPA_CATEGORY")

public class Category {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String categoryName;
	@ManyToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Product> product = new ArrayList<>();
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", product=" + product + "]";
	}

	public Category(Long id, String categoryName, List<Product> product) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.product = product;
	}

	public Category() {
		super();
	}

}
