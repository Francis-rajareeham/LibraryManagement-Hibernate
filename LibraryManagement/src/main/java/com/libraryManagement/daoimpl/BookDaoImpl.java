package com.libraryManagement.daoimpl;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.libraryManagement.dao.BookDao;

import com.libraryManagement.entity.Book;

public class BookDaoImpl implements BookDao{
	private final SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public void addBook(Book book){
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.save(book);
			t.commit();
			System.out.println("Successfully saved.");
			session.close();
			
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateBook(Book book){
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.update(book);
			t.commit();
			System.out.println("Successfully updated.");		
			session.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteBook(Book book) {
		try {
			
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.remove(book);	
			t.commit();
			System.out.println("Successfully removed.");
			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	
	
	}
	
	public Book getBookById(int bookId) {
		try(Session session = sf.openSession()){
			return session.get(Book.class, bookId);
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBook(){
		List<Book> allBook = new ArrayList<Book>();
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			allBook = session.createQuery("from Book").list();
			t.commit();
			session.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return allBook;
	}

}

