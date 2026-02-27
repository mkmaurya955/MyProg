package com.ecom.productservice.service;

import com.ecom.productservice.dto.ProductResponseDto;

public interface ProductService {
	
	ProductResponseDto getProductById(Long id);
	
	String updateProductQuantity(Long id, Integer quantity);

}
