package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Address;
import com.kkhibernate.entity.Employee;

public class ClientOneToManyBDExample {

	public static void main(String[] args) {
		saveRecord();
		getRecordEmployee();
		getRecordAddress();
	}

	private static void saveRecord() {
		Employee employee = new Employee("Bibhu Samal", "bibhu@gmail.com", new Date(), 65000.00);
		Address address1 = new Address("bangalore", "karnataka", 560037l);
		Address address2 = new Address("cuttack", "odisha", 754204l);
		Address address3 = new Address("bellandur", "karnataka", 560103l);
		employee.getAddressList().add(address1);
		employee.getAddressList().add(address2);
		employee.getAddressList().add(address3);
		
		address1.setEmployee(employee);
		address2.setEmployee(employee);
		address3.setEmployee(employee);
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}
	
	private static void getRecordEmployee() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class,	1);
		System.out.println(employee);
		employee.getAddressList().forEach(System.out::println);
		session.getTransaction().commit();
	}
	
	private static void getRecordAddress() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Address address = session.get(Address.class, 1);
		System.out.println(address);
		System.out.println(address.getEmployee());
		session.getTransaction().commit();
	}
}
