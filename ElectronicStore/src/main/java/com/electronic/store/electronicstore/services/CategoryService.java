package com.electronic.store.electronicstore.services;

import java.util.List;

import com.blog.api.payloads.CategoriesDto;

public interface CategoryService {
	
	CategoriesDto createNewCategory(CategoriesDto categoriesDto);

	CategoriesDto updateCategory(CategoriesDto categoriesDto, String categoryId);

	void deleteByCategory(String categoryId);
	
	List<CategoriesDto> getAllCategory();
	
	CategoriesDto getById(String categoryId);
	

}
