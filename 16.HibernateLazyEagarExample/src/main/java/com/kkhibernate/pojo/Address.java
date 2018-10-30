package com.kkhibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="city_name")
	private String city;
	
	@Column(name="state_name")
	private String state;
	
	@Column(name="zipcode_name")
	private Long zipcode;

	public Address() {
		super();
	}

	public Address(String city, String state, Long zipcode) {
		super();
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
}
