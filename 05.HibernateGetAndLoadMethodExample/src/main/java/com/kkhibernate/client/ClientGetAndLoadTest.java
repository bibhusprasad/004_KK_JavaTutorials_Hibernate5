package com.kkhibernate.client;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Employee;

public class ClientGetAndLoadTest {

	public static void main(String[] args) {
		getRecord();
		loadRecord();
	}
	
	private static void getRecord() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, 2);
		System.out.println("get() : "+employee);
		session.getTransaction().commit();
	}
	
	private static void loadRecord() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.load(Employee.class, 2);
		System.out.println("load() : "+employee);
		session.getTransaction().commit();
	}

	

}
