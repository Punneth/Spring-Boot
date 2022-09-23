package com.itoItTracker.assignment.spring.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private int categoryId;
	private int subCategoryId;
	private Integer assigneeId;
	private Integer reportedId;
	private Integer priorityId;
	private String subject;
	private Integer statusId;
	private String description;
	private String createDateTime;
	private String lastModifiedDateTime;
	
	@OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Comments> comments;
	
	@OneToOne(mappedBy = "ticket")
	private User user;
	
	public Ticket() {
		super();
	}
	
	public Ticket(int ticketId, int categoryId, int subCategoryId, Integer assigneeId, Integer reportedId,Integer priorityId,
			String subject, Integer statusId, String description, String createDateTime, String lastModifiedDateTime) {
		
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
	
	public List<Comments> getComments() {
		return comments;
	}
	
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setReportedId(Integer reportedId) {
		this.reportedId = reportedId;
	}
	
	public int getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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
	
	public Integer getAssigneeId() {
		return assigneeId;
	}
	
	public void setAssigneeId(Integer assigneeId) {
		this.assigneeId = assigneeId;
	}
	
	public int getReportedId() {
		return reportedId;
	}
	
	public void setReportedId(int reportedId) {
		this.reportedId = reportedId;
	}
	
	public Integer getPriorityId() {
		return priorityId;
	}
	
	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Integer getStatusId() {
		return statusId;
	}
	
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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
}

