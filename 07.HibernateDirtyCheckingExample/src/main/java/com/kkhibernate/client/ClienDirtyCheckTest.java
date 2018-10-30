package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Employee;

public class ClienDirtyCheckTest {

	public static void main(String[] args) {
		saveRecord();
		dirtyCheck();
	}

	private static void saveRecord() {
		Employee employee = new Employee("Alok dash", "alok.dash@gmail.com", new Date(), 65000.00);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}

	private static void dirtyCheck() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Employee employee = session.get(Employee.class, 1);
		if(null != employee) {
			session.beginTransaction();
			employee.setSalary(75000.00);
			session.update(employee);
			session.getTransaction().commit();
		}
		session.clear();
	}

}
