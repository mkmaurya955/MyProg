package com.ecom.productservice.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ecom.productservice.dto.CategoryDto;
import com.ecom.productservice.entity.Category;
import com.ecom.productservice.entity.Product;
import com.ecom.productservice.mapper.CategoryDtoMapper;
import com.ecom.productservice.mapper.ProductDtoMapper;
import com.ecom.productservice.repository.CategoryRepository;
import com.ecom.productservice.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		List<Product> list = null;
		Category saveCategory = null;
		Optional<Category> byName = categoryRepository.findByName(categoryDto.getName());
		if (byName.isPresent()) {
			Category category = byName.get();
			if (!CollectionUtils.isEmpty(categoryDto.getProduct())) {
				list = categoryDto.getProduct().stream().map(productDto -> {
					Product product = new Product();
					product.setName(productDto.getName());
					product.setDescription(productDto.getDescription());
					product.setPrice(productDto.getPrice());
					product.setStockQuantity(productDto.getStockQuantity());
					product.setInStock(productDto.getInStock());
					product.setCategory(category);
					return product;
				}).collect(Collectors.toList());

			}
			category.setProduct(list);
			saveCategory = categoryRepository.save(category);
		} else {
			Category cat = new Category();
			cat.setName(categoryDto.getName());
			cat.setDescription(categoryDto.getDescription());

			if (!CollectionUtils.isEmpty(categoryDto.getProduct())) {
				list = categoryDto.getProduct().stream().map(productDto -> {
					Product product = new Product();
					product.setName(productDto.getName());
					product.setDescription(productDto.getDescription());
					product.setPrice(productDto.getPrice());
					product.setStockQuantity(productDto.getStockQuantity());
					product.setInStock(productDto.getInStock());
					product.setCategory(cat);
					return product;
				}).collect(Collectors.toList());
			}
			cat.setProduct(list);
			saveCategory = categoryRepository.save(cat);
		}
		CategoryDto convertCategoryDto = CategoryDtoMapper.convertCategoryDto(saveCategory);
		return convertCategoryDto;

	}

	@Override
	public CategoryDto findById(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found..!!"));
		CategoryDto categoryDto = CategoryDtoMapper.convertCategoryDto(category);
		return categoryDto;
	}

	@Override
	public List<CategoryDto> findAll() {
		List<Category> all = categoryRepository.findAll();
		List<CategoryDto> collect = all.stream().map(CategoryDtoMapper::convertCategoryDto)
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto) {
		Optional<Category> category = Optional.ofNullable(categoryRepository.findById(categoryDto.getId())
				.orElseThrow(() -> new RuntimeException("Category not found..!!")));
		CategoryDto categoryDto2 = null;
		if (category.isPresent()) {
			Category category2 = category.get();
			category2.setName(categoryDto.getName());
			category2.setDescription(category2.getDescription());
			category2.setProduct(categoryDto.getProduct().stream().map(ProductDtoMapper::convertIntoProduct)
					.collect(Collectors.toList()));
			Category save = categoryRepository.save(category2);
			categoryDto2 = CategoryDtoMapper.convertCategoryDto(save);
		}
		return categoryDto2;
	}

	@Override
	public void deleteCategory(Long id) {
		Optional<Category> category = Optional.ofNullable(
				categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found..!!")));
		categoryRepository.deleteById(category.get().getId());
	}

}
