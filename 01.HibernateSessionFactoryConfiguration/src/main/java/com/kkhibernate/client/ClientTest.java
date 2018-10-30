package com.kkhibernate.client;

import org.hibernate.Session;

//import com.kkhibernate.HibernateSessionFactoryOne;
import com.kkhibernate.HibernateSessionFactoryTwo;

public class ClientTest {

	public static void main(String[] args) {

		// Session session = HibernateSessionFactoryOne.getSessionFactory().openSession();
		Session session = HibernateSessionFactoryTwo.getSessionFactory().openSession();
		String sqlVersion = "SELECT version();";
		String result = (String) session.createNativeQuery(sqlVersion).getSingleResult();
		System.out.println("Hibernate version is : " + result);
	}
}
