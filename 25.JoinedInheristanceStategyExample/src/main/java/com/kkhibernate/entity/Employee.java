package com.kkhibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_table")
public class Employee extends Person{
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="joinDate")
	private Date joinDate;
	
	@Column(name="salary")
	private Double salary;
	
	public Employee() {
		super();
	}

	public Employee(String email, Date joinDate, Double salary) {
		super();
		this.email = email;
		this.joinDate = joinDate;
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [email=" + email + ", joinDate=" + joinDate + ", salary=" + salary + "]";
	}
}
