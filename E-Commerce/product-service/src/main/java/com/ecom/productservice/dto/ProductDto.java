package com.ecom.productservice.dto;

import lombok.Data;
@Data
public class ProductDto {
	
	private Long id;
	
	private String name;

	private String description;

	private String price;

	private Integer stockQuantity;

	private Boolean inStock;
	
}
