package com.marcelo.mystore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.mystore.DTO.ProductDTO;
import com.marcelo.mystore.entity.Product;

import com.marcelo.mystore.repository.ProductRepository;
import com.marcelo.mystore.searchingEngine.ProductCriteriaRepository;
import com.marcelo.mystore.searchingEngine.ProductPage;
import com.marcelo.mystore.searchingEngine.ProductSearchCriteria;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public Product saveProduct(Product product) {

		return productRepository.save(product);

	}

	public Page<Product> getAll(Integer pageNumber, Integer pageQtd) {
		Pageable pageable = PageRequest.of(pageNumber, pageQtd);
		Page<Product> products = productRepository.findAll(pageable);
		return products;
	}

	public Page<Product> pageByBrand (Integer pageNumber,Integer pageQtd,String brand){
		Pageable pageable = PageRequest.of(pageNumber,pageQtd);
		Page<Product> products= productRepository.findByBrand(brand, pageable);
		return products;
	}
	public Page<Product> pageByPriceBetween (Integer pageNumber,Integer pageQtd,Integer price1, Integer price2){
		Pageable pageable = PageRequest.of(pageNumber,pageQtd);
		Double value1 = price1 + 0.00;
		Double value2 = price2 + 0.00;
		Page<Product> products= productRepository.findByPriceBetween(value1, value2, pageable);
		return products;
	}
	public Page<Product> pageByDescriptionContains (Integer pageNumber,Integer pageQtd,String description){
		Pageable pageable = PageRequest.of(pageNumber,pageQtd);
		Page<Product> products= productRepository.findByDescriptionContains(description, pageable);
		return products;
	}
	
	private final ProductCriteriaRepository productCriteriaRepository;
	
	public ProductService(ProductRepository productRepository,
						  ProductCriteriaRepository productCriteriaRepository) {
		this.productCriteriaRepository = productCriteriaRepository;
		this.productRepository = productRepository;
	}
	
	public Page<Product> getProducts(ProductPage productPage,
									 ProductSearchCriteria productSearchCriteria){
		return productCriteriaRepository.findAllWithFilters(productPage, productSearchCriteria);
		
	}
	
	/*
	 * public Page<Product> addProduct(){
	 * 
	 * }
	 */

}
