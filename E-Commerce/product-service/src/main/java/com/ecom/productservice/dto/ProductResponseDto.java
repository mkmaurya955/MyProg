package com.ecom.productservice.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
	
private Long id;
	
	private String name;

	private String description;

	private String price;

	private Integer stockQuantity;

	private Boolean inStock;
	
	private CategoryProductResponseDto categoryProductResponseDto;

}
