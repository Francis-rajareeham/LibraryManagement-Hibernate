package com.libraryManagement.dao;

import java.util.List;

import com.libraryManagement.entity.Author;

public interface AuthorDao {
	public void addAuthor(Author author);
	public void updateAuthor(Author author);
	public void deleteAuthor(Author author);
	public Author getAuthorById(int authId);
	public List<Author> getAllAuthor();
}
