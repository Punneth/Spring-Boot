package com.itoItTracker.assignment.spring.Dto;

import org.springframework.stereotype.Component;

@Component
public class TicketDto1 {
	
	private int ticketId;
	private String categoryId;
	private String subCategoryId;
	private Integer assigneeId;
	private int reportedId;
	private String priorityId;
	private String subject;
	private String statusId;
	private String description;
	private String createDateTime;
	private String lastModifiedDateTime;
	
	public TicketDto1() {
		super();
	}
	
	public TicketDto1(int ticketId, String categoryId, String subCategoryId, Integer assigneeId, int reportedId,
			String priorityId, String subject, String statusId, String description, String createDateTime,
			String lastModifiedDateTime) {
		
		super();
		this.ticketId = ticketId;
		this.categoryId = categoryId;
		this.subCategoryId = subCategoryId;
		this.assigneeId = assigneeId;
		this.reportedId = reportedId;
		this.priorityId = priorityId;
		this.subject = subject;
		this.statusId = statusId;
		this.description = description;
		this.createDateTime = createDateTime;
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public void setPriorityId(String priorityId) {
		this.priorityId = priorityId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public Integer getAssigneeId() {
		return assigneeId;
	}
	
	public void setAssigneeId(Integer assigneeId) {
		this.assigneeId = assigneeId;
	}
	
	public int getReportedId() {
		return reportedId;
	}
	
	public String getPriorityId() {
		return priorityId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setReportedId(int reportedId) {
		this.reportedId = reportedId;
	}
		
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
		
}

