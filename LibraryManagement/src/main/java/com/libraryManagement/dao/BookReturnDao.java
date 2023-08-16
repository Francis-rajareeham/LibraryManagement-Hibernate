package com.libraryManagement.dao;

import com.libraryManagement.entity.BookReturn;

public interface BookReturnDao {
	void addBookReturn(BookReturn b_return);
	void updateBookReturn(BookReturn b_return);
	void deleteBookReturn(BookReturn b_return);

}
