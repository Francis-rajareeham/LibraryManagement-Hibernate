package com.libraryManagement.dao;

import java.util.List;

import com.libraryManagement.entity.Borrowed;

public interface BorrowedDao {
	public void addBorrowed(Borrowed borrowed);
	public void updateBorrowed(Borrowed borrowed);
	public void deleteBorrowed(Borrowed borrowed);
	public Borrowed getBorrowedByMemId(int memId);
	public List<Borrowed> getAllBorrowed();
	public Borrowed getBorrowedByBorrowId(int borrowId);
}
