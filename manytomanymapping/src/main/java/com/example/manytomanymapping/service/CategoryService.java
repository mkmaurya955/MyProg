package com.example.manytomanymapping.service;

import org.springframework.http.ResponseEntity;

import com.example.manytomanymapping.entity.Category;

public interface CategoryService {

	void saveCategory(Category category);

	ResponseEntity<Category> getAllMethod();

	ResponseEntity<Category> getById(String id);

	ResponseEntity<String> deleteById(String id);

	void update(Category category);

}
