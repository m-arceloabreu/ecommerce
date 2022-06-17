package com.marcelo.mystore.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class BusinessAddress {

	@Column(name = "business_street_name", length = 40)
	@NotBlank
	private String businessStreetName;
	
	@Column(name = "business_number", length = 5)
	@NotNull
	private int businessNumber;
	
	@Column(name = "business_district", length = 30)
	@NotBlank
	private String businessDistrict;
	
	@Column(name = "business_city", length = 30)
	@NotBlank
	private String businessCity;
	
	@Column(name = "business_state", length = 2)
	@NotBlank
	private String businessState;
	
	@Column(name = "business_zip_code", length = 8)
	@NotNull
	private String businessZipCode;
	
	@Column(name = "business_region", length = 10)
	private String businessRegion;

	
	public String getBusinessStreetName() {
		return businessStreetName;
	}

	public void setBusinessStreetName(String businessStreetName) {
		this.businessStreetName = businessStreetName;
	}

	public int getBusinessNumber() {
		return businessNumber;
	}

	public void setBusinessNumber(int businessNumber) {
		this.businessNumber = businessNumber;
	}

	public String getBusinessDistrict() {
		return businessDistrict;
	}

	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}

	public String getBusinessCity() {
		return businessCity;
	}

	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}

	public String getBusinessState() {
		return businessState;
	}

	public void setBusinessState(String businessState) {
		this.businessState = businessState;
	}

	public String getBusinessZipCode() {
		return businessZipCode;
	}

	public void setBusinessZipCode(String businessZipCode) {
		this.businessZipCode = businessZipCode;
	}

	public String getBusinessRegion() {
		return businessRegion;
	}

	public void setBusinessRegion(String businessRegion) {
		this.businessRegion = businessRegion;
	}
	
	
}
