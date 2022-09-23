package com.itoItTracker.assignment.spring.Dto;

import org.springframework.stereotype.Component;

@Component
public class CommentHelperClass {
	
	private Integer userId;
	private String comment;
	
	public CommentHelperClass() {
		super();
	}

	public CommentHelperClass(Integer userId, String comment) {
		super();
		this.userId = userId;
		this.comment = comment;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
		
}
