package com.kkhibernate.client;

import org.hibernate.Session;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Employee;
import com.kkhibernate.entity.Person;
import com.kkhibernate.entity.Student;

public class JoinedInheritanceStrategyExample {

	public static void main(String[] args) {
		saveRecord();
		getRecordEmployee();
	}

	private static void saveRecord() {
		Person person = new Person("Bibhu Samal", "male");
		Employee employee = new Employee("bibhu@gmail.com", HibernateSessionFactory.getDate("18/12/2018"), 65000d);
		employee.setName("Alok");
		employee.setGender("male");
		Student student = new Student("apmbnp", 3000d, "A");
		student.setName("ankita");
		student.setGender("female");
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(person);
		session.save(student);
		session.save(employee);
		session.getTransaction().commit();
	}
	
	private static void getRecordEmployee() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		Person person = session.get(Person.class, 1);
		System.out.println(person);
		session.getTransaction().commit();
	}
}
