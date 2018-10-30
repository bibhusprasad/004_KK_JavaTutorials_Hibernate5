package com.kkhibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kkhibernate.entity.Employee;
import com.kkhibernate.entity.EmployeeBackup;

public class HibernateSessionFactoryTwo {

	private static SessionFactory sessionFactory;

	static {
		
		//import java.util.Properties;
		Properties prop = new Properties();
		
		// JDBC Database connection settings
		prop.setProperty("hibernate.connection.driver_class",  "com.mysql.jdbc.Driver");
		prop.setProperty("hibernate.connection.url",  "jdbc:mysql://localhost:3306/kkhibernate?useSSL=false");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "ipsitadas");
        
        // Select our SQL dialect
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        
        // Echo the SQL to stdout
        prop.setProperty("hibernate.show_sql", "true");
        
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
		
        if(null == sessionFactory) {
        	sessionFactory = new Configuration()
        			.setProperties(prop)
        			.addAnnotatedClass(Employee.class)
        			.addAnnotatedClass(EmployeeBackup.class)
        			.buildSessionFactory();
        }
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
