package com.kkhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryTwo {

	private static SessionFactory sessionFactory;

	static {
		if (null == sessionFactory) {
			sessionFactory = new Configuration()
							.configure("hibernate.cfg.xml")
							.buildSessionFactory();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
