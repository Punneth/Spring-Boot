package com.itoItTracker.assignment.spring.Dto;

public class AdminTeamDto {
	
	private int adminId;
	private String name;
	private String emailId;
	
	public AdminTeamDto() {
		super();
	}

	public AdminTeamDto(int adminId, String name, String emailId) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.emailId = emailId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

}
