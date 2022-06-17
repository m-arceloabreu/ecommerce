package com.marcelo.mystore.searchingEngine;

import org.springframework.data.domain.Sort;

public class ProductPage {
	
	private int pageNumber = 0;
	private int pageSize = 5;
	
	
	public ProductPage(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	
	
	
}
