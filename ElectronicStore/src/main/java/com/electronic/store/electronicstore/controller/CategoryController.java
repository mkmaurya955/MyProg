package com.electronic.store.electronicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.payloads.CategoriesDto;
import com.electronic.store.electronicstore.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create")
	public ResponseEntity<CategoriesDto> createCategory(@RequestBody CategoriesDto categoriesDto){
		
		CategoriesDto createNewCategory = categoryService.createNewCategory(categoriesDto);
		
		return new ResponseEntity<>(createNewCategory, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<CategoriesDto> updateCategory(@RequestBody CategoriesDto categoriesDto, @RequestParam("categoryId") String categoryId){
		CategoriesDto  cateDto = categoryService.updateCategory(categoriesDto, categoryId);
		return new ResponseEntity<>(cateDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/getById")
	public ResponseEntity<CategoriesDto> getById(@RequestParam("categoryId") String categoryId){
		CategoriesDto byId = categoryService.getById(categoryId);
		return new ResponseEntity<>(byId, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoriesDto>> getAllCategory(){
		List<CategoriesDto> allCategory = categoryService.getAllCategory();
		return new ResponseEntity<>(allCategory, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete")
	public void deleteCategory(@RequestParam("categoryId") String categoryId){
		categoryService.deleteByCategory(categoryId);
	}
}
