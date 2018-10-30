package com.kkhibernate.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.kkhibernate.HibernateSessionFactory;
import com.kkhibernate.entity.Address;
import com.kkhibernate.entity.Employee;

public class ClientOneToOneBDExample {

	public static void main(String[] args) {
		saveRecord();
		
		getEmployeeAndAddressByEmployeeId();
		getEmployeeAndAddressByAddressId();
		getEmployeeNameAndSalaryByEmployeeId();
	}

	private static void saveRecord() {
		Employee employee = new Employee("Bibhu Samal", "bibhu@gmail.com", new Date(), 65000.00);
		Address address = new Address("bangalore", "karnataka", 560037l);
		employee.setAddress(address);
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}
	
	private static void getEmployeeAndAddressByEmployeeId() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		String readHql = "FROM Employee emp LEFT JOIN FETCH emp.address WHERE emp.empid=:empId";
		Query<Employee> createQuery = session.createQuery(readHql, Employee.class);
		createQuery.setParameter("empId", 1);
		Employee employee = createQuery.uniqueResult();
		System.out.println("====> Employee And Address details by empId.");
		System.out.println(employee);
		System.out.println(employee.getAddress());
	}
	
	private static void getEmployeeAndAddressByAddressId() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		String readHql = "FROM Address add LEFT JOIN FETCH add.employee WHERE add.addressid=:addId";
		Query<Address> createQuery = session.createQuery(readHql, Address.class);
		createQuery.setParameter("addId", 1);
		Address address = createQuery.uniqueResult();
		System.out.println("====> Adfdress And Employee details by empId.");
		System.out.println(address);
		System.out.println(address.getEmployee());
	}
	
	@SuppressWarnings("unchecked")
	private static void getEmployeeNameAndSalaryByEmployeeId() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		String readHql = "SELECT emp.empName, emp.salary, addr.city, addr.zipcode " + 
				"FROM Employee emp LEFT JOIN emp.address addr WHERE emp.empid=:empId";
		Query<Object[]> createQuery = session.createQuery(readHql);
		createQuery.setParameter("empId", 1);
		List<Object[]> resultList = createQuery.list();
		System.out.println("====> Employee name, salary, city and zipcode details by empId.");
		for(Object[] obj : resultList) {
			String empName = (String) obj[0];
			Double salary = (Double) obj[1];
			String city = (String) obj[2];
			Long zipcode = (Long) obj[3];
			System.out.println(empName+" "+salary+" "+city+" "+zipcode);
		}
	}
}
