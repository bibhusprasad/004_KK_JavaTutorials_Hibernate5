package com.kkhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address_table")
public class Address {

	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer address_id;
	
	@Column(name="city_name")
	private String city;
	
	@Column(name="state_name")
	private String state;
	
	@Column(name="zipcode_name")
	private Long zipcode;

	public Address(String city, String state, Long zipcode) {
		super();
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public Address() {
		super();
	}

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ "]";
	}
}
