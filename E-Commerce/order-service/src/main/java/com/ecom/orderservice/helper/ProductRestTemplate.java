package com.ecom.orderservice.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ecom.orderservice.dto.ProductResponseDto;

@Component
public class ProductRestTemplate {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ProductResponseDto getProductById(Long productId) {
		String url = "http://localhost:8081/product/"+productId;
		ProductResponseDto forObject = restTemplate.getForObject(url, ProductResponseDto.class);
		return forObject;
	}
	
	public String updateProductQuantity(Long productId, Integer quantity) {
		String url = "http://localhost:8081/product/updateStock/"+productId+"/stockQuantity/"+quantity;
		String stringObj = restTemplate.getForObject(url, String.class);
		return stringObj;
	}

}
