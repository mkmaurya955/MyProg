package com.ecom.productservice.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.productservice.dto.ProductResponseDto;
import com.ecom.productservice.entity.Product;
import com.ecom.productservice.mapper.ProductDtoMapper;
import com.ecom.productservice.repository.ProductRepository;
import com.ecom.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductResponseDto getProductById(Long id) {
		
		Optional<Product> byId = productRepository.findById(id);
		Product product = byId.get();
		ProductResponseDto convertIntoProductResponseDto = ProductDtoMapper.convertIntoProductResponseDto(product);
		return convertIntoProductResponseDto;
	}

	@Override
	public String updateProductQuantity(Long id,Integer quantity) {
		Optional<Product> byId = productRepository.findById(id);
		if(byId.isPresent()) {
			Product product = byId.get();
			Integer stockQuantity = product.getStockQuantity();
			Integer remainingQty = stockQuantity-quantity;
			product.setStockQuantity(remainingQty);
			productRepository.save(product);
		}
		return "Product Stock has been updated..!!";
	}

}
