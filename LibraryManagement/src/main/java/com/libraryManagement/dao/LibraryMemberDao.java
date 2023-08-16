package com.libraryManagement.dao;

import java.util.List;

import com.libraryManagement.entity.LibraryMember;

public interface LibraryMemberDao {
	void addLibraryMember(LibraryMember member);
	void updateLibraryMember(LibraryMember member);
	void deleteLibraryMember(LibraryMember member);
	public LibraryMember getMemberById(int memId);
	public List<LibraryMember> getAllMember();

}
