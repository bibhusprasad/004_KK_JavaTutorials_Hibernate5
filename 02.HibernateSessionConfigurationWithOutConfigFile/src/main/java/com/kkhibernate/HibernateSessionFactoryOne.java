package com.kkhibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateSessionFactoryOne {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	static {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		Map<String, String> dbSettings = new HashMap<String, String>();

		dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/kkhibernate?useSSL=false");
		dbSettings.put(Environment.USER, "root");
		dbSettings.put(Environment.PASS, "ipsitadas");

		dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

		dbSettings.put(Environment.SHOW_SQL, "true");
		dbSettings.put(Environment.HBM2DDL_AUTO, "create");
		
		standardServiceRegistryBuilder.applySettings(dbSettings);
		standardServiceRegistry = standardServiceRegistryBuilder.build();

		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata = metadataSources.getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
