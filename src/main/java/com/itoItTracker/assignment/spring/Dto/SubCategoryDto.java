package com.itoItTracker.assignment.spring.Dto;

public class SubCategoryDto {
	
	private int subCategoryId;
	private String subCategoryDesc;
	private int categoryId;
	
	public SubCategoryDto() {
		super();
	}
	
	public SubCategoryDto(int subCategoryId, String subCategoryDesc, int categoryId) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryDesc = subCategoryDesc;
		this.categoryId = categoryId;
	}
	
	public int getSubCategoryId() {
		return subCategoryId;
	}
	
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	public String getSubCategoryDesc() {
		return subCategoryDesc;
	}
	
	public void setSubCategoryDesc(String subCategoryDesc) {
		this.subCategoryDesc = subCategoryDesc;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
