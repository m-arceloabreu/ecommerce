package com.marcelo.mystore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="client")
public class Client {

	@Id
	@Column(name="cpf" , length = 12)
	private String cpf;
	@Column(name="name" , length = 40)
	private String name;
	@Column(name="birth_date" )
	private Date birthDate;
	@Column(name="martial_state" , length = 12)
	private String martialState;
	
	@Embedded
	private Address residencialAddress;
	@Embedded
	private BusinessAddress businessAddress;
	@Column(name="status")
	private boolean status;
	
	public Client() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMartialState() {
		return martialState;
	}

	public void setMartialState(String martialState) {
		this.martialState = martialState;
	}

	public Address getResidencialAddress() {
		return residencialAddress;
	}

	public void setResidencialAddress(Address residencialAddress) {
		this.residencialAddress = residencialAddress;
	}

	public BusinessAddress getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(BusinessAddress businessAddress) {
		this.businessAddress = businessAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
