package com.libraryManagement;

import java.util.List;
import java.util.Scanner;

import com.libraryManagement.dao.AuthorDao;
import com.libraryManagement.dao.BookDao;
import com.libraryManagement.dao.BookReturnDao;
import com.libraryManagement.dao.BorrowedDao;
import com.libraryManagement.dao.LibraryMemberDao;
import com.libraryManagement.daoimpl.AuthorDaoImpl;
import com.libraryManagement.daoimpl.BookDaoImpl;
import com.libraryManagement.daoimpl.BookReturnDaoImpl;
import com.libraryManagement.daoimpl.BorrowedDaoImpl;
import com.libraryManagement.daoimpl.LibraryMemberDaoImpl;
import com.libraryManagement.entity.Author;
import com.libraryManagement.entity.Book;
import com.libraryManagement.entity.Borrowed;
import com.libraryManagement.entity.LibraryMember;

public class AppController {
	AuthorDao auth = new AuthorDaoImpl();
	BookDao bk = new BookDaoImpl();
	BookReturnDao br = new BookReturnDaoImpl();
	BorrowedDao borrow = new BorrowedDaoImpl();
	LibraryMemberDao mem = new LibraryMemberDaoImpl();
	Scanner sc = new Scanner(System.in);
	
	
	
	public void bookAdd() {
		Book book = new Book();
		System.out.println("Enter Book Title : ");
		book.setBookName(sc.next());
		System.out.println("Enter Author Name : ");
		book.setBookAuthor(sc.next());
		System.out.println("Enter Category : " );
		book.setBookCategory(sc.next());
		System.out.println("Enter Publication Date ; ");
		book.setPubDate(sc.next());
		System.out.println("Enter the number of copies available : ");
		book.setBookCopies(sc.nextInt());
		bk.addBook(book);
	}
	public void bookUpdate() {
		System.out.println("Enter Book ID to update : ");
		int bookId = sc.nextInt();
		Book book = bk.getBookById(bookId);
		if(book!=null) {
			System.out.println("Book ID          : " + book.getBookId());
			System.out.println("Book Title       : " + book.getBookName());
			System.out.println("Book Author      : " + book.getBookAuthor());
			System.out.println("Book Category    : " + book.getBookCategory());
			System.out.println("Publication Date : " + book.getPubDate());
			System.out.println("Copies Available : " + book.getBookCopies());
			
			System.out.println("Choose Field to Update");
			System.out.println("1. Book Name");
			System.out.println("2. Book Author");
			System.out.println("3. Book Category");
			System.out.println("4. Publication Date");
			System.out.println("5. Copies Available");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter new book name: ");
				book.setBookName(sc.next());
				break;
			case 2:
				System.out.println("Enter new author name: ");
				book.setBookAuthor(sc.next());
				break;
			case 3:
				System.out.println("Enter new category: ");
				book.setBookCategory(sc.next());
				break;
			case 4:
				System.out.println("Enter new publication date: ");
				book.setPubDate(sc.next());
				break;
			case 5:
				System.out.println("Enter new number of copies: ");
				book.setBookCopies(sc.nextInt());
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			bk.updateBook(book);
			System.out.println("Update Successful");
		}
		else {
			System.out.println("Book Not Found");
		}
	}
	
	public void bookDelete() {
		System.out.println("Enter Book ID to delete: ");
		int bookId = sc.nextInt();
		Book book = bk.getBookById(bookId);
		if(book!=null) {
			bk.deleteBook(book);
			System.out.println("Successfully Deleted");
		}
		else {
			System.out.println("Book not found");
		}
	}
	
	public void getAllBook(){
		System.out.println("All Book Details");
		List<Book> books = bk.getAllBook();
		if(!books.isEmpty()) {
			String format = "| %-8s | %-15s | %-15s | %-15s | %-15s | %-15s | %n ";
            System.out.printf(format, "Book ID", "Book Name", "Book Author", "Book Category", "Publication Date", "Copies Available");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

            for (Book book : books) {
                System.out.printf(format,
                        book.getBookId(),
                        book.getBookName(),
                        book.getBookAuthor(),
                        book.getBookCategory(),
                        book.getPubDate(),
                        book.getBookCopies());
            }
		}
		else {
			System.out.println("No book found");
		}
	}
	
	public void authorAdd(){
		Author author = new Author();
		System.out.println("Enter the first name of author : ");
		author.setAuthFName(sc.next());
		System.out.println("Enter the last name of author : ");
		author.setAuthLName(sc.next());
		
		auth.addAuthor(author);
		System.out.println("Added Successfully");
	}
	
	public void authorUpdate() {
		System.out.println("Enter the Author ID to update");
		int authId = sc.nextInt();
		Author author = auth.getAuthorById(authId);
		if(author!=null) {
			System.out.println("Author ID         : " + author.getAuthId());
			System.out.println("Author First Name : " + author.getAuthFName());
			System.out.println("Author Last Name  : " + author.getAuthLName());
			
			System.out.println("Choose Field to Update");
			System.out.println("1. Author First Name");
			System.out.println("2. Author Last Name");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter new first name : ");
				author.setAuthFName(sc.next());
				break;
			case 2:
				System.out.println("Enter new last name : ");
				author.setAuthLName(sc.next());
				break;
			default:
				System.out.println("Invalid Input");
			}
			auth.updateAuthor(author);
			System.out.println("Update Successful");
			
		}
		else {
			System.out.println("No author found");
		}
		
	}
	
	public void authorDelete() {
		System.out.println("Enter Author ID to delete: ");
		int authId = sc.nextInt();
		Author author = auth.getAuthorById(authId);
		if(author!=null) {
			auth.deleteAuthor(author);
			System.out.println("Successfully Deleted");
		}
		else {
			System.out.println("Author not found");
		}
	}
	
	
	public void getAllAuthor() {
		System.out.println("All Autor Details");
		List<Author> authors = auth.getAllAuthor();
		if(!authors.isEmpty()) {
			String format = "| %-10s | %-25s | %-25s | %n ";
            System.out.printf(format, "Author ID", "First Name", "Last Name");
            System.out.println("----------------------------------------------------------------------------------------------");

            for (Author author : authors) {
                System.out.printf(format,
                        author.getAuthId(),
                        author.getAuthFName(),
                        author.getAuthLName());
            }
		}
		else {
			System.out.println("No author found");
		}
	}
	public void memberAdd() {
		LibraryMember member = new LibraryMember();
		System.out.println("Enter the First Name of Member : ");
		member.setMemFName(sc.next());
		System.out.println("Enter the Last Name of Member : ");
		member.setMemLName(sc.next());
		System.out.println("Enter the join date");
		member.setJoinDate(sc.next());
		member.setTotalBooksBorrowed(0);
		mem.addLibraryMember(member);
	}
	public void memberUpdate() {
		System.out.println("Enter Member ID to update : ");
		int memId = sc.nextInt();
		LibraryMember member = mem.getMemberById(memId);
		if(member!=null) {
			System.out.println("Member ID                          : " + member.getMemId());
			System.out.println("Member First Name                  : " + member.getMemFName());	
			System.out.println("Member Last Name                   : " + member.getMemLName());		
			System.out.println("Joining Date of Member             : " + member.getJoinDate());		
			System.out.println("Number of Books borrowed by Member : " + member.getTotalBooksBorrowed());
			
			System.out.println("Choose Field to Update : ");
			System.out.println("1. Member First Name");
			System.out.println("2. Member Last Name");
			System.out.println("3. Joining Date of Member");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter new First Name : ");
				member.setMemFName(sc.next());
				break;
			case 2:
				System.out.println("Enter new Last Name : ");
				member.setMemLName(sc.next());
				break;
			case 3:
				System.out.println("Enter new joining date : ");
				member.setJoinDate(sc.next());
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			mem.updateLibraryMember(member);
			System.out.println("Update Successful");
		}
		else {
			System.out.println("Author not found");
		}
	}
	public void memberDelete() {
		System.out.println("Enter Member ID to Delete : ");
		int memId = sc.nextInt();
		LibraryMember member = mem.getMemberById(memId);
		if(member!=null) {
			mem.deleteLibraryMember(member);
			System.out.println("Successfully Deleted");
		}
		else {
			System.out.println("Member not found");
		}
	}
	public void getAllMember() {
		System.out.println("All Member Details");
		List<LibraryMember> members = mem.getAllMember();
		if(!members.isEmpty()){
			String format = "| %-10s | %-25s | %-25s | %-25s | %-25s | %n ";
            System.out.printf(format, "Member ID", "Member First Name", "Member Last Name", "Join Date", "Books Borrowed");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

            for (LibraryMember member : members) {
                System.out.printf(format,
                        member.getMemId(),
                        member.getMemFName(),
                        member.getMemLName(),
                        member.getJoinDate(),
                        member.getTotalBooksBorrowed());
            }
		}
		else {
			System.out.println("No Member found");
		}
	}
	public void borrowedAdd() {
		Borrowed borrowed = new Borrowed();
		System.out.println("Enter the Book ID : ");
		borrowed.setBookId(sc.nextInt());
		System.out.println("Enter the Member ID : ");
		borrowed.setMemId(sc.nextInt());
		System.out.println("Enter the borrowed date : ");
		borrowed.setBorrowDate(sc.next());
		System.out.println("Enter the return date");
		borrowed.setReturnDate(sc.next());
		System.out.println("Enter the return status : ");
		borrowed.setReturnStatus(sc.next());
		borrow.addBorrowed(borrowed);
	}
	public void borrowedUpdate() {
		System.out.println("Enter Borrow ID to update");
		int borrowId = sc.nextInt();
		Borrowed borrowed = borrow.getBorrowedByBorrowId(borrowId);
		if(borrowed!=null) {
			System.out.println("Borrow Id     : "+ borrowed.getBorrowId());
			System.out.println("Book ID       : "+ borrowed.getBookId());
			System.out.println("Member ID     : "+ borrowed.getMemId());
			System.out.println("Borrowed Date : "+ borrowed.getBorrowDate());
			System.out.println("Return Date   : "+ borrowed.getReturnDate());
			System.out.println("Return Status : "+ borrowed.getReturnStatus());
			
			System.out.println("Choose Field to Update");
			System.out.println("1. Book ID");
			System.out.println("2. Member ID");
			System.out.println("3. Borrowed Date");
			System.out.println("4. Return Date");
			System.out.println("5. Return Status");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter new Book ID: ");
				borrowed.setBookId(sc.nextInt());
				break;
			case 2:
				System.out.println("Enter new Member ID: ");
				borrowed.setMemId(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter new Borrow Date: ");
				borrowed.setBorrowDate(sc.next());
				break;
			case 4:
				System.out.println("Enter new Return Date: ");
				borrowed.setReturnDate(sc.next());
				break;
			case 5:
				System.out.println("Enter new Return Status: ");
				borrowed.setReturnStatus(sc.next());
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			borrow.updateBorrowed(borrowed);
			System.out.println("Update Successful");
		}
		else {
			System.out.println("Borrow record not found");
		}
	}
		
	
	public void borrowedDelete() {
		System.out.println("Enter Borrow Id to delete: ");
		int borrowId = sc.nextInt();
		Borrowed borrowed = borrow.getBorrowedByBorrowId(borrowId);
		if(borrowed!=null) {
			borrow.deleteBorrowed(borrowed);
			System.out.println("Successfully Deleted");
		}
	}
	public void getAllBorrowed() {
		System.out.println("All Borrow Details");
		List<Borrowed> loan = borrow.getAllBorrowed();
		if(!loan.isEmpty()) {
			String format = "| %-10s | %-10s | %-10s | %-15s | %-15s | %-15s | %n ";
            System.out.printf(format, "Borrow ID", "Book ID", "Member ID", "Borrow Date", "Return Date", "Return Status");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

            for (Borrowed borrowed : loan) {
                System.out.printf(format,
                		borrowed.getBorrowId(),
                        borrowed.getBookId(),
                        borrowed.getMemId(),
                        borrowed.getBorrowDate(),
                        borrowed.getReturnDate(),
                        borrowed.getReturnStatus());
            }
		}
		else {
			System.out.println("No record found");
		}
	}
}
	

