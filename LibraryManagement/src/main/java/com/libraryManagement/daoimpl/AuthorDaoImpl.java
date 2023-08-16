package com.libraryManagement.daoimpl;


import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.libraryManagement.dao.AuthorDao;
import com.libraryManagement.entity.Author;

public class AuthorDaoImpl implements AuthorDao {
	private final SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public void addAuthor(Author author) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.save(author);
			t.commit();
			System.out.println("Successfully saved.");
			session.close();
			
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	@Override
	public void updateAuthor(Author author) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.update(author);
			t.commit();
			System.out.println("Successfully updated.");		
			session.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
		
	@Override
	public void deleteAuthor(Author author) {
		try {
			
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.remove(author);	
			t.commit();
			System.out.println("Successfully removed.");
			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Author getAuthorById(int authId) {
		try(Session session = sf.openSession()){
			return session.get(Author.class, authId);
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAllAuthor(){
		List<Author> allAuthor = new ArrayList<Author>();
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			allAuthor = session.createQuery("from Author").list();
			t.commit();
			session.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return allAuthor;
	}

}
