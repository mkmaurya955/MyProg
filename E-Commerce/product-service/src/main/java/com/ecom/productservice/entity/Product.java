package com.ecom.productservice.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ECOM_PRODUCT")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String description;

	private String price;

	private Integer stockQuantity;

	private Boolean inStock;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonBackReference
	private Category category;

	@PrePersist
	@PostUpdate
	public void updateStockStatus() {
		this.inStock = this.stockQuantity != null && this.stockQuantity > 0;
		if (createdAt == null) {
			createdAt = LocalDateTime.now();
			updatedAt = LocalDateTime.now();
		}
	}

}
