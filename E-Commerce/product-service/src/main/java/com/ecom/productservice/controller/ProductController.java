package com.ecom.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productservice.dto.ProductResponseDto;
import com.ecom.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public ProductResponseDto getByProductId(@PathVariable("id") Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/updateStock/{id}/stockQuantity/{quantity}")
	public String updateProductQuantity(@PathVariable("id") Long id, @PathVariable("quantity") Integer quantity) {
		String updateProductQuantity = productService.updateProductQuantity(id,quantity);
		return updateProductQuantity;
	}
}
