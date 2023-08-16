package com.libraryManagement.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int authId;
	@Column(name="First_Name")
	private String authFName;
	@Column(name="Last_Name")
	private String authLName;
	
	
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getAuthFName() {
		return authFName;
	}
	public void setAuthFName(String authFName) {
		this.authFName = authFName;
	}
	public String getAuthLName() {
		return authLName;
	}
	public void setAuthLName(String authLName) {
		this.authLName = authLName;
	}
	
	
}
