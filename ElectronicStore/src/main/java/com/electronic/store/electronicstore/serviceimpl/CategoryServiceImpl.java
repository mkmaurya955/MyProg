package com.electronic.store.electronicstore.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.api.payloads.CategoriesDto;
import com.electronic.store.electronicstore.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Override
	public CategoriesDto createNewCategory(CategoriesDto categoriesDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriesDto updateCategory(CategoriesDto categoriesDto, String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByCategory(String categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriesDto> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriesDto getById(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
