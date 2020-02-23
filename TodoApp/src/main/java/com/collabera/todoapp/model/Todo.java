package com.collabera.todoapp.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	
	private int id;
	@Size(min=5, message= "Description field should contain 5 or more characters")
	private String description;
	private String user;
	private Date targetDate;
	private boolean status;
	public Todo(int id, String description, String user, Date targetDate, boolean status) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
		this.targetDate = targetDate;
		this.status = status;
	}
	
	public Todo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", user=" + user + ", targetDate=" + targetDate
				+ ", status=" + status + "]";
	}
	
	

}
