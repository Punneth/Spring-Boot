package com.itoItTracker.assignment.spring.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommentsDtoClass {
		
		private Integer ticketId;
		private String category;
		private String subCategory;
		private String subject;
		private String priority;
		private String status;
		private String assignee;
		private List<CommentHelperClass> comments;
		
		public CommentsDtoClass(Integer ticketId, String category, String subCategory, String subject, String priority,
				String status, String assignee, List<CommentHelperClass> comments) {
			
			super();
			this.ticketId = ticketId;
			this.category = category;
			this.subCategory = subCategory;
			this.subject = subject;
			this.priority = priority;
			this.status = status;
			this.assignee = assignee;
			this.comments = comments;
		}

		public CommentsDtoClass() {
			super();
		}
		
		public Integer getTicketId() {
			return ticketId;
		}
		
		public void setTicketId(Integer ticketId) {
			this.ticketId = ticketId;
		}
		
		public String getCategory() {
			return category;
		}
		
		public void setCategory(String category) {
			this.category = category;
		}
		
		public String getSubCategory() {
			return subCategory;
		}
		
		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}
		
		public String getSubject() {
			return subject;
		}
		
		public void setSubject(String subject) {
			this.subject = subject;
		}
		
		public String getPriority() {
			return priority;
		}
		
		public void setPriority(String priority) {
			this.priority = priority;
		}
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		
		public String getAssignee() {
			return assignee;
		}
		
		public void setAssignee(String assignee) {
			this.assignee = assignee;
		}

		public List<CommentHelperClass> getComments() {
			return comments;
		}

		public void setComments(List<CommentHelperClass> comments) {
			this.comments = comments;
		}
}
