package com.libraryManagement.daoimpl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.libraryManagement.dao.LibraryMemberDao;
import com.libraryManagement.entity.LibraryMember;

public class LibraryMemberDaoImpl implements LibraryMemberDao{
	private final SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Override
	public void addLibraryMember(LibraryMember member) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.save(member);
			t.commit();
			System.out.println("Successfully saved.");
			session.close();
			
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void updateLibraryMember(LibraryMember member) {
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.update(member);
			t.commit();
			System.out.println("Successfully updated.");		
			session.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteLibraryMember(LibraryMember member) {
		try {
			
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			session.remove(member);	
			t.commit();
			System.out.println("Successfully removed.");
			session.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	
	
	}
	public LibraryMember getMemberById(int memId) {
		try(Session session = sf.openSession()){
			return session.get(LibraryMember.class, memId);
		}catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LibraryMember> getAllMember(){
		List<LibraryMember> allMem = new ArrayList<LibraryMember>();
		try {
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			allMem = session.createQuery("from Mem").list();
			t.commit();
			session.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return allMem;
	}

	


}

