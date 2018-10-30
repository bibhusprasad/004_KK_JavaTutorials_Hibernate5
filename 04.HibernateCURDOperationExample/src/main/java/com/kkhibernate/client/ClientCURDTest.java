package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Employee;

public class ClientCURDTest {

	public static void main(String[] args) {
		saveRecord();
		getRecord();
		updateRecord();
		deleteRecord();

	}

	private static void saveRecord() {
		Employee employee = new Employee("Bibhu Samal", "bibhusprasad@gmail.com", new Date(), 65000.00);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(employee);
		session.getTransaction().commit();
	}

	private static void getRecord() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, 1);
		session.getTransaction().commit();
		System.out.println(employee);
	}

	private static void updateRecord() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, 1);
		employee.setEmpName("BIBHU SAMAL");
		session.update(employee);
		session.getTransaction().commit();
	}

	public static void deleteRecord() { 
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction(); 
		Employee employee = session.get(Employee.class, 1);
		session.delete(employee);
		session.getTransaction().commit(); 
	}

}
