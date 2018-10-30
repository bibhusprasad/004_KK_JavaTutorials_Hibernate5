package com.kkhibernate.client;

import java.util.Date;

import org.hibernate.Session;

//import com.kkhibernate.HibernateSessionFactoryOne;
import com.kkhibernate.HibernateSessionFactoryTwo;
import com.kkhibernate.entity.Employee;

public class ClientSaveTest {

	public static void main(String[] args) {
		
		// get Session Object
		Session session = HibernateSessionFactoryTwo.getSessionFactory().openSession();
		
		// create Employee Object
		Employee employee = new Employee("Alok Dash", "dash.alok01@gmail.com", new Date(), 70000.00);
		
		// start transaction
		session.beginTransaction();
		
		// save the employee
		int id = (Integer) session.save(employee);
		System.out.println("Id : "+ id);
		
		// commit the transaction
		session.getTransaction().commit();
	}

}
