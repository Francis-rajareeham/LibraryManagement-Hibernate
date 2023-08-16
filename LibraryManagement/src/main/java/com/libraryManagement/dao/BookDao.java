package com.libraryManagement.dao;

import java.util.List;

import com.libraryManagement.entity.Book;

public interface BookDao {
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Book book);
	public Book getBookById(int bookId);
	public List<Book> getAllBook();
}
