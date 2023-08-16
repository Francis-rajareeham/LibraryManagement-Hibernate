package com.libraryManagement.daoimpl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.libraryManagement.dao.BorrowedDao;
import com.libraryManagement.entity.Borrowed;

public class BorrowedDaoImpl implements BorrowedDao {
	private final SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public void addBorrowed(Borrowed borrowed) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.save(borrowed);
			t.commit();
			System.out.println("Successfully saved.");
			session.close();
			
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateBorrowed(Borrowed borrowed) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.update(borrowed);
			t.commit();
			System.out.println("Successfully updated.");		
			session.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteBorrowed(Borrowed borrowed) {
		try {
			
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.remove(borrowed);	
			t.commit();
			System.out.println("Successfully removed.");
			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	
	
	}
	public Borrowed getBorrowedByMemId(int memId) {
		try(Session session = sf.openSession()){
			return session.get(Borrowed.class, memId);
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	
	public Borrowed getBorrowedByBorrowId(int borrowId) {
		try(Session session = sf.openSession()){
			return session.get(Borrowed.class, borrowId);
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrowed> getAllBorrowed(){
		List<Borrowed> allBorrowed = new ArrayList<Borrowed>();
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			allBorrowed = session.createQuery("from Borrowed").list();
			t.commit();
			session.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return allBorrowed;
	}

	




}

