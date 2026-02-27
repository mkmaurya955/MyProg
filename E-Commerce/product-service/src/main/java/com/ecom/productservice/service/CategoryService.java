package com.ecom.productservice.service;

import java.util.List;

import com.ecom.productservice.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	CategoryDto findById(Long id);
	
	List<CategoryDto> findAll();
	
	CategoryDto updateCategory(CategoryDto categoryDto);
	
	void deleteCategory(Long id);

}
