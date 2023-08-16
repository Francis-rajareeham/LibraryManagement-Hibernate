package com.libraryManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Library_Member")
public class LibraryMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int memId;
	@Column(name="First_Name")
	private String memFName;
	@Column(name="Last_Name")
	private String memLName;
	@Column(name="Join_Date")
	private String joinDate;
	@Column(name="No_Of_Books_Borrowed")
	private int totalBooksBorrowed;
	

	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getMemFName() {
		return memFName;
	}
	public void setMemFName(String memFName) {
		this.memFName = memFName;
	}
	public String getMemLName() {
		return memLName;
	}
	public void setMemLName(String memLName) {
		this.memLName = memLName;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public int getTotalBooksBorrowed() {
		return totalBooksBorrowed;
	}
	public void setTotalBooksBorrowed(int totalBooksBorrowed) {
		this.totalBooksBorrowed = totalBooksBorrowed;
	}
	
}
