package com.marcelo.mystore.searchingEngine;

import java.util.List;

public class ProductSearchCriteria {

	private String brand;
	private String description;
	private Integer priceMin = 0;
	private Integer priceMax = 100000000;
	private List<String> materials ;
	private List<String> sizes ;
	
	
	
	public ProductSearchCriteria(String brand, String description, 
									Integer priceMin, Integer priceMax, List<String> materials, List<String> sizes) {
		super();
		this.brand = brand;
		this.description = description;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
		this.materials = materials;
		this.sizes = sizes;
		
	}
	
	
	


	public List<String> getMaterials() {
		return materials;
	}





	public void setMaterials(List<String> materials) {
		this.materials = materials;
	}





	public List<String> getSizes() {
		return sizes;
	}





	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}





	public Integer getPriceMin() {
		return priceMin;
	}


	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}


	public Integer getPriceMax() {
		return priceMax;
	}


	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
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


	


	
	
	
}
