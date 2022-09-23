package com.itoItTracker.assignment.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_category")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCategoryId;
	
	@Column(name="subCategory_des")
	private String subCategoryDesc;
	
	private int categoryId;
	
	
	public SubCategory() {
		super();
	}
	
	public SubCategory(int subCategoryId, String subCategoryDesc) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryDesc = subCategoryDesc;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
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
	
}

