package com.ecom.productservice.mapper;

import java.util.stream.Collectors;

import com.ecom.productservice.dto.CategoryDto;
import com.ecom.productservice.entity.Category;

public class CategoryDtoMapper {
	
	public static CategoryDto convertCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setDescription(category.getDescription());
		categoryDto.setProduct(category.getProduct().stream().map(ProductDtoMapper::convertIntoProductDto).collect(Collectors.toList()));
		return categoryDto;
	}

}
