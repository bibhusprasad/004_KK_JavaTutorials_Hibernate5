package com.kkhibernate.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.kkhibernate.pojo.Address;

@Entity
@Table(name="employee_table")
@DynamicUpdate
public class Employee {
	
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empid;
	
	@Column(name="emp_name", length=20, nullable=false)
	private String empName;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="joinDate")
	private Date joinDate;
	
	@Column(name="salary")
	private Double salary;
	
	@Embedded
	@AttributeOverrides(value = { 
			@AttributeOverride(column = @Column(name="home_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name="home_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name="home_zipcode_name"), name = "zipcode")
			})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides(value = { 
			@AttributeOverride(column = @Column(name="office_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name="office_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name="office_zipcode_name"), name = "zipcode")
			})
	private Address officeAddress;

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Employee() {
		super();
	}

	public Employee(String empName, String email, Date joinDate, Double salary) {
		super();
		this.empName = empName;
		this.email = email;
		this.joinDate = joinDate;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", email=" + email + ", joinDate=" + joinDate
				+ ", salary=" + salary + ", homeAddress=" + homeAddress + ", officeAddress=" + officeAddress + "]";
	}
}
