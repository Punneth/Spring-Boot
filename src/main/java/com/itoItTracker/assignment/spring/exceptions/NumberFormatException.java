//package com.itoItTracker.assignment.spring.exceptions;
//
//public class NumberFormatException extends RuntimeException {
//	
//	String resourceName;
//	String fieldName;
//	int fieldValue;
//
//	public NumberFormatException(String resourceName, int fieldValue,String fieldName) {
//		super(String.format("%s   %s : %s", resourceName,fieldValue, fieldName));
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.fieldValue = fieldValue;
//	}
//
//	public NumberFormatException(String resourceName) {
//		super(resourceName);
//	}
//
//	public String getResourceName() {
//		return resourceName;
//	}
//
//	public void setResourceName(String resourceName) {
//		this.resourceName = resourceName;
//	}
//
//	public String getFieldName() {
//		return fieldName;
//	}
//
//	public void setFieldName(String fieldName) {
//		this.fieldName = fieldName;
//	}
//
//	public int getFieldValue() {
//		return fieldValue;
//	}
//
//	public void setFieldValue(int fieldValue) {
//		this.fieldValue = fieldValue;
//	}
//
//
//}
