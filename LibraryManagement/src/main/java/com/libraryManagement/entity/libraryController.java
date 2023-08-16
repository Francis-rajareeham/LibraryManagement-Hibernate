package com.libraryManagement.entity;

import java.util.Scanner;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class libraryController {
	public static void main(String args[]){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		Author a1 = new Author();
		System.out.println("Enter First Name: ");
		a1.setAuthFName(sc.next());
		System.out.println("Enter Last name: ");
		a1.setAuthLName(sc.next());
		session.save(a1);
		t.commit();
		session.close();
		sf.close();
	}
}
