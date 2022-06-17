package com.marcelo.mystore.DTO;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.marcelo.mystore.entity.Address;
import com.marcelo.mystore.entity.BusinessAddress;

public class ClientDTO {

	@CPF
	@NotNull
	private String cpf;
	@NotBlank
	private String name;
	private Date birthDate;
	@NotBlank
	private String martialState;
	@Embedded
	@NotNull
	private Address residencialAddress;
	@Embedded
	private BusinessAddress businessAddress;
	@NotNull
	private boolean status;

	public ClientDTO() {}
	
	public ClientDTO (String cpf, String name, Date birthDate,  String martialState,
			 Address residencialAddress, BusinessAddress businessAddress,  boolean status) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.birthDate = birthDate;
		this.martialState = martialState;
		this.residencialAddress = residencialAddress;
		this.businessAddress = businessAddress;
		this.status = status;
	}

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
