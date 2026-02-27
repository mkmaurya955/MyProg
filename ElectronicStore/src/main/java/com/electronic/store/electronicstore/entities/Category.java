package com.electronic.store.electronicstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class Category {
	
	@Id
	@Column(name = "ID")
	private String categoryId;
	@Column(name = "category_title")
	private String title;
	@Column(name = "category_desc")
	private String description;
	
	private String coverImage;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", title=" + title + ", description=" + description
				+ ", coverImage=" + coverImage + "]";
	}

	public Category(String categoryId, String title, String description, String coverImage) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.coverImage = coverImage;
	}

	public Category() {
		super();
	}

}
