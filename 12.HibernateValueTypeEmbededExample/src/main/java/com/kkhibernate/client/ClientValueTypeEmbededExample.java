package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Employee;
import com.kkhibernate.pojo.Address;

public class ClientValueTypeEmbededExample {

	public static void main(String[] args) {
		saveRecord();
		getRecord();
	}

	private static void saveRecord() {
		Address address = new Address("cuttack", "odisha", 754204l);
		Employee employee = new Employee("Bibhu Samal", "bibhu@gmail.com", new Date(), 65000.00);
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
		session.getTransaction().commit();
	}

	

}
