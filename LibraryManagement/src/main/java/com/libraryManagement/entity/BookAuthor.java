package com.libraryManagement.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book_Author")
public class BookAuthor {
	@Id
	@Column(name="Book_ID")
	private int bookId;
	@Column(name="Author_ID")
	private int authID;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getAuthID() {
		return authID;
	}
	public void setAuthID(int authID) {
		this.authID = authID;
	}
	
}
