package com.ecom.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productservice.dto.CategoryDto;
import com.ecom.productservice.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping(value = "/createCategory",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
		return categoryService.createCategory(categoryDto);
	}
	
	@PostMapping("/findAll")
	public List<CategoryDto> findAllCategory(){
		return categoryService.findAll();
	}
	@PostMapping("/getById/{id}")
	public CategoryDto findByIdcategCategoryDto(@PathVariable("id") Long id) {
		return categoryService.findById(id);
	}
}
