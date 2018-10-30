package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Employee;

public class ClienGeneratorTableExample {

	public static void main(String[] args) {
		saveRecord1();
		saveRecord2();
		saveRecord3();
	}

	private static void saveRecord1() {
		Employee employee = new Employee("Bibhu Samal", "bibhu@gmail.com", new Date(), 65000.00);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}

	private static void saveRecord2() {
		Employee employee = new Employee("Alok dash", "alok.dash@gmail.com", new Date(), 75000.00);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}
	
	private static void saveRecord3() {
		Employee employee = new Employee("Asu Panda", "asupanda@gmail.com", new Date(), 45000.00);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}

}
