package com.marcelo.mystore.controller;


import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.mystore.DTO.ProductDTO;
import com.marcelo.mystore.entity.Product;
import com.marcelo.mystore.repository.ProductRepository;
import com.marcelo.mystore.searchingEngine.ProductPage;
import com.marcelo.mystore.searchingEngine.ProductSearchCriteria;

import com.marcelo.mystore.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;
	


	@PostMapping("/")
	public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductDTO productDTO) {

		if (productRepository.existsBySku(productDTO.getSku()) == true) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This CPF is  already registred");
		}

		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		productService.saveProduct(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@PutMapping("/{sku}")
	public ResponseEntity<Object> updateProduct(@PathVariable(value = "sku") Long sku,
			@Valid @RequestBody ProductDTO productDTO) {
		productDTO.setSku(sku);
		Product productUpdated = productRepository.findBySku(sku).get();

		BeanUtils.copyProperties(productDTO, productUpdated);

		return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productUpdated));
	}

	@DeleteMapping("/delete/{sku}")
	public void deleteBySku(@PathVariable(value = "sku") Long sku) {
		productRepository.delete(productRepository.findBySku(sku).get());
	}
	
	@GetMapping("/search")
	ResponseEntity<Page<Product>> getProducts(
			@RequestParam(value = "pageNumber" ,defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5" ) Integer pageSize, 
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "priceMin", required = false, defaultValue = "0") Integer priceMin,
			@RequestParam(value = "priceMax", required = false, defaultValue = "100000000") Integer priceMax,
			@RequestParam(value = "materials", required = false) List<String> materials,
			@RequestParam(value = "sizes", required = false) List<String> sizes
			){
			ProductPage productPage = new ProductPage(pageNumber, pageSize);
			ProductSearchCriteria productSearchCriteria = 
							new ProductSearchCriteria(brand, description, priceMin, priceMax, materials, sizes);
			
		return new ResponseEntity<>(productService.getProducts(productPage, productSearchCriteria),
				HttpStatus.OK);
	}
	
}
