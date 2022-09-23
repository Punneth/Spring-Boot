package com.itoItTracker.assignment.spring.Dto;

public class CommentsDto {
	
	private int commentId;
	private int ticketId;
	private int userId;
	private String message;
	
	private TicketDto ticket;
	private UserDto user;
	
	public TicketDto getTicket() {
		return ticket;
	}

	public void setTicket(TicketDto ticket) {
		this.ticket = ticket;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CommentsDto() {
		super();
	}
	
	public CommentsDto(int commentId, int ticketId, int userId, String message) {
		super();
		this.commentId = commentId;
		this.ticketId = ticketId;
		this.userId = userId;
		this.message = message;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
