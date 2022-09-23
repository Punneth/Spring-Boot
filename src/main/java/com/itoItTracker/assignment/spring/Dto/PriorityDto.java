package com.itoItTracker.assignment.spring.Dto;

public class PriorityDto {
	
	private Integer priorityId;
	private String priority;
	
	public PriorityDto() {
		super();
	}

	public PriorityDto(Integer priorityId, String priority) {
		super();
		this.priorityId = priorityId;
		this.priority = priority;
	}

	public Integer getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
