package com.kkhibernate.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@ElementCollection
	@JoinTable(name="address_table", joinColumns=@JoinColumn(name="emp_id"))
	private List<Address> address;

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

	public List<Address> getAddress() {
		if(null == address) {
			address = new ArrayList<>();
		}
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
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
				+ ", salary=" + salary + ", address=" + address + "]";
	}
	
	
}
