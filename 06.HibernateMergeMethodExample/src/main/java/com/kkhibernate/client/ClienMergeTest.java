package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Employee;

public class ClienMergeTest {

	public static void main(String[] args) {
		saveRecord();
		updateRecord();
	}
	
	private static void saveRecord() {
		Employee employee = new Employee("Alok dash", "alok.dash@gmail.com", new Date(), 65000.00);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}

	private static void updateRecord() {
		Session session1 = HibernateSessionFactory.getSessionFactory().openSession();
		Employee employee1 = session1.get(Employee.class, 1);
		System.out.println(employee1);
		session1.close();
		employee1.setSalary(95000.00);
		
		Session session2 = HibernateSessionFactory.getSessionFactory().openSession();
		Employee employee2 = session2.get(Employee.class, 1);
		System.out.println(employee2);
		employee2.setEmail("bibhu082@gmail.com");
		
		session2.beginTransaction();
		//session2.update(employee1); 
		/*
		 * Exception in thread "main" org.hibernate.NonUniqueObjectException: 
		 * A different object with the same identifier value 
		 * was already associated with the session : [com.kkhibernate.entity.Employee#1]
		 */
		
		session2.merge(employee1);
		session2.getTransaction().commit();
		
	}

}
