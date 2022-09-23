package com.itoItTracker.assignment.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	private String message;
	private Integer ticketId;
	private Integer userId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Ticket ticket;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Comments() {
		super();
	}

	public Comments(int commentId, String message, Integer ticketId, Integer userId, Ticket ticket, User user) {
		super();
		this.commentId = commentId;
		this.message = message;
		this.ticketId = ticketId;
		this.userId = userId;
		this.ticket = ticket;
		this.user = user;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
