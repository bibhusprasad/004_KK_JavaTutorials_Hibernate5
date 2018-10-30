package com.kkhibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.kkhibernate.HibernateSessionFactoryTwo;
import com.kkhibernate.entity.Employee;
import com.kkhibernate.entity.EmployeeBackup;

public class ClientHQLInsertAndReadExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateSessionFactoryTwo.getSessionFactory();
		saveEmployeeBackupRecords(sessionFactory);
		
		insertEmployeeRecordHql(sessionFactory);
		
		getAllEmployeesDetailsHQL(sessionFactory);
		getEmployeeByIdHQL(sessionFactory, 1);
		getEmployeeByIdAndEmailHQL(sessionFactory);
		getAllEmployeesNamesHQL(sessionFactory);
		
		updateEmployeeEmailDetailsHql(sessionFactory);
		
		deleteEmployeeDetailHql(sessionFactory);
	}
	
	private static void saveEmployeeBackupRecords(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		EmployeeBackup employee1 = new EmployeeBackup("Bibhu Samal", "bibhu@gmail.com", 65000d);
		EmployeeBackup employee2 = new EmployeeBackup("Asu Panda", "asu@gmail.com", 55000d);
		EmployeeBackup employee3 = new EmployeeBackup("Alok Dash", "alok@gmail.com", 75000d);
		
		session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.getTransaction().commit();
		session.close();
	}
	
	private static void insertEmployeeRecordHql(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		String insertHql = "INSERT INTO Employee (name, email, salary)" + 
		"SELECT name, email, salary FROM EmployeeBackup";
		Query<?> createQuery = session.createQuery(insertHql);
		session.beginTransaction();
		int noRecords = createQuery.executeUpdate();
		if(noRecords > 0) {
			System.out.println(noRecords + " record created.");
		}
		session.getTransaction().commit();
		session.close();
	}
	
	private static void getAllEmployeesDetailsHQL(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		String readHql = "FROM Employee";
		Query<?> createQuery = session.createQuery(readHql);
		//List<?> resultList = createQuery.list();
		List<?> resultList = createQuery.list();
		System.out.println("====> List of Emloyee details.");
		resultList.forEach(System.out::println);
		session.close();
	}

	private static void getEmployeeByIdHQL(SessionFactory sessionFactory, int empId) {
		Session session = sessionFactory.openSession();
		String readHql = "FROM Employee WHERE id=?0";
		Query<Employee> createQuery = session.createQuery(readHql, Employee.class);
		createQuery.setParameter(0, empId);
		Employee uniqueResult = createQuery.uniqueResult();
		System.out.println("====> Employee Details for  id = " + empId);
		System.out.println(uniqueResult);
		session.close();
	}
	
	private static void getEmployeeByIdAndEmailHQL(SessionFactory sessionFactory) {
		int employeeId = 1;
		String employeeEmail = "bibhu@gmail.com";
		Session session = sessionFactory.openSession();
	//	String readHql = "FROM Employee where id=?0 AND email=?1";
		String readHql = "FROM Employee where id=:empId AND email=:empEmail";
		Query<Employee> createQuery = session.createQuery(readHql, Employee.class);
	//	createQuery.setParameter(0, employeeId);
	//	createQuery.setParameter(1, employeeEmail);
		createQuery.setParameter("empId", employeeId);
		createQuery.setParameter("empEmail", employeeEmail);
		Employee employee = createQuery.uniqueResult();
		System.out.println("====> Employee Details for id and Email = " + employeeId + " & "+ employeeEmail);
		System.out.println(employee);
		session.close();
	}
		
	private static void getAllEmployeesNamesHQL(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		String readHql = "SELECT name FROM Employee";
		Query<String> query = session.createQuery(readHql, String.class);
		List<String> employees = query.list();
		System.out.println("====> List of Employee name details.");
		employees.forEach(System.out::println);
		session.close();
	}
	
	private static void updateEmployeeEmailDetailsHql(SessionFactory sessionFactory) {
		int employeeId = 1;
		String employeeEmail = "bibhuprasad082@gmail.com";
		Session session = sessionFactory.openSession();
		String updateHql = "UPDATE Employee SET email=:empEmail WHERE id=:empId";
		Query<?> createQuery = session.createQuery(updateHql);
		createQuery.setParameter("empEmail", employeeEmail);
		createQuery.setParameter("empId", employeeId);
		session.beginTransaction();
		int noRecord = createQuery.executeUpdate();
		session.getTransaction().commit();
		System.out.println("====> Employee record update : "+noRecord);
		getEmployeeByIdHQL(sessionFactory, employeeId);
		session.close();
	}
	
	private static void deleteEmployeeDetailHql(SessionFactory sessionFactory) {
		int employeeId = 3;
		Session session = sessionFactory.openSession();
		String deleteHql = "DELETE FROM Employee where id=:empId";
		Query<?> createQuery = session.createQuery(deleteHql);
		createQuery.setParameter("empId", employeeId);
		session.beginTransaction();
		int noRecord = createQuery.executeUpdate();
		session.getTransaction().commit();
		System.out.println("====> Employee record deleted : "+noRecord);
		session.close();
		getAllEmployeesDetailsHQL(sessionFactory);
	}
}
