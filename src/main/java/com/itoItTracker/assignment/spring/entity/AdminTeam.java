package com.itoItTracker.assignment.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_team")
public class AdminTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@Column(name = "admin_name")
	private String name;
	
	@Column(name = "admin_emailId")
	private String emailId;
	
	public AdminTeam() {
		super();
	}

	public AdminTeam(int adminId, String name, String emailId) {
		
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
