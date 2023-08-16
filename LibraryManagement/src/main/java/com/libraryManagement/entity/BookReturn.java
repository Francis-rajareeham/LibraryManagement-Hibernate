package com.libraryManagement.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book_Return")
public class BookReturn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Borrow_ID")
	private int borrowId;
	@Column(name="Member_ID")
	private int memId;
	@Column(name="Book_ID")
	private int bookId;
	@Column(name="Return_Status")
	private boolean returnStatus;
	
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public boolean getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(boolean returnStatus) {
		this.returnStatus = returnStatus;
	}
	
}
