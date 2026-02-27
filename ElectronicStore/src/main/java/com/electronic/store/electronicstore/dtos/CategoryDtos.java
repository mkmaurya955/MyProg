package com.electronic.store.electronicstore.dtos;

public class CategoryDtos {
	
	private String categoryId;
	private String title;
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
		return "CategoryDtos [categoryId=" + categoryId + ", title=" + title + ", description=" + description
				+ ", coverImage=" + coverImage + "]";
	}

	
}
