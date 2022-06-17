package com.marcelo.mystore.DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductDTO {
	@Id
	@NotNull(message = " Sku can't be null!")
	@Column(unique = true)
	private Long sku;
	@NotBlank(message = "Brand should not be null")
	private String brand;
	@NotBlank(message = "Description should not be null")
	private String description;
	@NotNull(message = "Price should not be null")
	@Positive(message = "This value has to be positive and different than ZERO")
	private double price;
	private String size;
	private String material;
	
	
	public Long getSku() {
		return sku;
	}
	public void setSku(Long sku) {
		this.sku = sku;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
	
	
}
