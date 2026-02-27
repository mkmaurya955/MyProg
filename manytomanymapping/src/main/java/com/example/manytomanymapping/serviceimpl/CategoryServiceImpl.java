package com.example.manytomanymapping.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.manytomanymapping.entity.Category;
import com.example.manytomanymapping.entity.Product;
import com.example.manytomanymapping.repository.CategoryRepository;
import com.example.manytomanymapping.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void saveCategory(Category category) {
		List<Product> product = category.getProduct();
		category.setProduct(product);
		categoryRepository.save(category);
	}

	@Override
	public ResponseEntity<Category> getAllMethod() {
		return null;
	}

	@Override
	public ResponseEntity<Category> getById(String id) {
		return null;
	}

	@Override
	public ResponseEntity<String> deleteById(String id) {
		return null;
	}

	@Override
	public void update(Category category) {
		
	}

}
