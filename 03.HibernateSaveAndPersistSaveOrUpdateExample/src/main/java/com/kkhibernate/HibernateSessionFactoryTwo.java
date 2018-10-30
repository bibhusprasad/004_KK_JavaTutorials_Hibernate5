package com.kkhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kkhibernate.entity.Employee;

public class HibernateSessionFactoryTwo {

	private static SessionFactory sessionFactory;

	static {
		if (null == sessionFactory) {
			sessionFactory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Employee.class)
							.buildSessionFactory();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
