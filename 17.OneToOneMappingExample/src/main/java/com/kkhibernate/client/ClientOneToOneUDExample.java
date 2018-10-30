package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Address;
import com.kkhibernate.entity.Employee;

public class ClientOneToOneUDExample {

	public static void main(String[] args) {
		saveRecord();
		getRecord();
	}

	private static void saveRecord() {
		Employee employee = new Employee("Bibhu Samal", "bibhu@gmail.com", new Date(), 65000.00);
		Address address = new Address("bangalore", "karnataka", 560037l);
		employee.setAddress(address);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}
	
	private static void getRecord() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class,	1);
		System.out.println(employee);
		System.out.println(employee.getAddress());
		session.getTransaction().commit();
	}

	

}
