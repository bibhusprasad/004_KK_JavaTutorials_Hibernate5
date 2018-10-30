package com.kkhibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
@DiscriminatorValue(value="student_record")
public class Student extends Person {

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "fee")
	private Double fee;

	@Column(name = "section_name")
	private String section_name;

	public Student(String schoolName, Double fee, String section_name) {
		super();
		this.schoolName = schoolName;
		this.fee = fee;
		this.section_name = section_name;
	}

	public Student() {
		super();
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	@Override
	public String toString() {
		return "Student [schoolName=" + schoolName + ", fee=" + fee + ", section_name=" + section_name + "]";
	}

}
