package com.itoItTracker.assignment.spring.Dto;

public class StatusDto {
	
	private int statusId;
	private String status;
	
	public StatusDto() {
		super();
	}
	
	public StatusDto(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
