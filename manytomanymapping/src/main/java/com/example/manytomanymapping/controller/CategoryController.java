package com.example.manytomanymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.manytomanymapping.entity.Category;
import com.example.manytomanymapping.service.CategoryService;

@RestController
@RequestMapping("/manytomany")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> createCategory(@RequestBody Category category){
		
		categoryService.saveCategory(category);
		
		return ResponseEntity.ok("Category Created..!");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteById(@RequestParam("id") String id){
		return categoryService.deleteById(id);
	}
	
	public ResponseEntity<String> updateCategory(@RequestBody Category category){
		categoryService.update(category);
		return ResponseEntity.ok("Updated Successfully..!");
	}
	
}
