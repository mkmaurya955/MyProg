package com.ecom.productservice.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CategoryDto {

	private Long id;

	private String name;

	private String description;

	private List<ProductDto> product = new ArrayList<>();

}
