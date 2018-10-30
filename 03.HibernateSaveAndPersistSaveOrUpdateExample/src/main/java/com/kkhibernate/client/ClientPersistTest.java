package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactoryOne;
import com.kkhibernate.entity.Employee;

public class ClientPersistTest {

	public static void main(String[] args) {

		Session session = HibernateSessionFactoryOne.getSessionFactory().openSession();
		Employee employee = new Employee("Bibhu samal", "bibhusprasad@gmail.com", new Date(), 65000.00);
		session.beginTransaction();
		session.persist(employee);
		session.getTransaction().commit();

	}
}
