package com.nitin.test;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="STREET_NAME")
    private String street;
	@Column(name="CITY_NAME")
    private String  city;
 

    	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


	
	
}
