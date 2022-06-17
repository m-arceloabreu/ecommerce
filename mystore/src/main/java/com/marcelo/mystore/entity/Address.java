package com.marcelo.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

	@Column(name="street_name", length = 40)
	@NotBlank
	private String streetName;
	
	@Column(name="number",length = 5)
	@NotNull
	private int number;
	
	@Column(name="district",length = 30)
	@NotBlank
	private String district;
	
	@Column(name="city",length = 30)
	@NotBlank
	private String city;
	
	@Column(name="state",length = 2)
	@NotBlank
	private String state;
	
	@Column(name="zip_code",length = 8)
	@NotNull
	private String zipCode;
	
	@Column(name="region",length = 10)
	private String region;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
