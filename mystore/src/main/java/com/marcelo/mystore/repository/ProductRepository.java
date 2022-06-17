package com.marcelo.mystore.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.mystore.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product>{

	public Optional<Product> findBySku(Long sku);
	boolean existsBySku(Long sku);
	public Product getProductBySku(Long sku);
	
	public Page<Product> findByBrand(String Brand, Pageable pageable);
	public Page<Product> findByPriceBetween(Double price, Double price2 , Pageable pageable);
	public Page<Product> findByDescriptionContains(String description, Pageable pageable);
	public Page<Product> findByMaterialContainsOrMaterialContains(String material1, String material2, Pageable pageable);
}
