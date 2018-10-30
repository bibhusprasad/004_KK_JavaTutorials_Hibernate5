package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactoryOne;
import com.kkhibernate.entity.Employee;

public class ClientSaveOrUpdateTest {
	
	public static void main(String[] args) {
		
		Session session = HibernateSessionFactoryOne.getSessionFactory().openSession();
		Employee e1 = new Employee("Bibhu Samal", "bibhusprasad@gmail.com", new Date(), 65000.00);
		Employee e2 = new Employee("Alok Dash", "dash.alok01@gmail.com", new Date(), 70000.00);
		
		session.beginTransaction();
		session.persist(e1);
		Integer id = (Integer)session.save(e2);
		System.out.println("Id : "+ id);
		e2.setEmpName("Ankita");
		session.saveOrUpdate(e2);
		session.getTransaction().commit();
	}

}
