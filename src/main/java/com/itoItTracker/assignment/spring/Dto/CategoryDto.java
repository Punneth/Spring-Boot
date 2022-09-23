package com.itoItTracker.assignment.spring.Dto;

import javax.validation.constraints.NotEmpty;

public class CategoryDto {
	
	private int categoryId;
	@NotEmpty()
	private String categoryDesc;
	
	public CategoryDto() {
		super();
	}
	
	public CategoryDto(int categoryId, String categoryDesc) {
		super();
		this.categoryId = categoryId;
		this.categoryDesc = categoryDesc;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}	
	
}
