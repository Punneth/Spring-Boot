package com.itoItTracker.assignment.spring.Dto;

public class UserDto {
	
	private int userId;	
	private String name;	
	private String emailId;
	private String createDateTime;
	private String lastModifiedDateTime;
	
	public UserDto() {
		
	}
	
	public UserDto(int userId, String name, String emailId, String createDateTime, String lastModifiedDateTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.createDateTime = createDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getCreateDateTime() {
		return createDateTime;
	}
	
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	
	public String getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}
	
	public void setLastModifiedDateTime(String lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
		
}
