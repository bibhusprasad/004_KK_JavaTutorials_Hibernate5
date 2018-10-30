package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Address;
import com.kkhibernate.entity.Employee;

public class ClientManyToManyExample {

	public static void main(String[] args) {
		saveRecord();
		getRecordEmployee();
	}

	private static void saveRecord() {
		Employee employee1 = new Employee("Bibhu Samal", "bibhu@gmail.com", new Date(), 65000.00);
		Employee employee2 = new Employee("Alok Dash", "alok@gmail.com", new Date(), 75000.00);
		Employee employee3 = new Employee("Asu Panda", "asu@gmail.com", new Date(), 55000.00);
		Address address1 = new Address("bangalore", "karnataka", 560037l);
		Address address2 = new Address("cuttack", "odisha", 754204l);
		Address address3 = new Address("bellandur", "karnataka", 560103l);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		employee1.getAddressList().add(address1);
		employee1.getAddressList().add(address2);
		employee2.getAddressList().add(address1);
		employee2.getAddressList().add(address3);
		employee3.getAddressList().add(address2);
		employee3.getAddressList().add(address3);		
		session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.getTransaction().commit();
	}
	
	private static void getRecordEmployee() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class,	1);
		System.out.println(employee);
		System.out.println(employee.getAddressList());
		session.getTransaction().commit();
	}
}
