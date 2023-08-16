package com.libraryManagement.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.libraryManagement.dao.BookReturnDao;
import com.libraryManagement.entity.BookReturn;


public class BookReturnDaoImpl implements BookReturnDao{
	private final SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public void addBookReturn(BookReturn b_return) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.save(b_return);
			t.commit();
			System.out.println("Successfully saved.");
			session.close();
			
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateBookReturn(BookReturn b_return) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.update(b_return);
			t.commit();
			System.out.println("Successfully updated.");		
			session.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteBookReturn(BookReturn b_return) {
		try {
			
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.remove(b_return);	
			t.commit();
			System.out.println("Successfully removed.");
			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	
	
	}	

}

