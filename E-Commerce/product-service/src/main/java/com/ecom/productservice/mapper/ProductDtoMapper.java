package com.ecom.productservice.mapper;

import com.ecom.productservice.dto.CategoryProductResponseDto;
import com.ecom.productservice.dto.ProductDto;
import com.ecom.productservice.dto.ProductResponseDto;
import com.ecom.productservice.entity.Category;
import com.ecom.productservice.entity.Product;

public class ProductDtoMapper {

	public static ProductDto convertIntoProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setInStock(product.getInStock());
		productDto.setPrice(product.getPrice());
		productDto.setStockQuantity(product.getStockQuantity());
		return productDto;
	}

	public static Product convertIntoProduct(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setInStock(productDto.getInStock());
		product.setPrice(productDto.getPrice());
		product.setStockQuantity(productDto.getStockQuantity());
		return product;
	}

	public static ProductResponseDto convertIntoProductResponseDto(Product product) {
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setId(product.getId());
		productResponseDto.setName(product.getName());
		productResponseDto.setDescription(product.getDescription());
		productResponseDto.setInStock(product.getInStock());
		productResponseDto.setPrice(product.getPrice());
		productResponseDto.setStockQuantity(product.getStockQuantity());
		Category category = product.getCategory();
		if (category != null) {
			CategoryProductResponseDto categoryDto = new CategoryProductResponseDto(
		        category.getId(),
		        category.getName()
		    );
			
		    productResponseDto.setCategoryProductResponseDto(categoryDto);
		}
		return productResponseDto;
	}

}
