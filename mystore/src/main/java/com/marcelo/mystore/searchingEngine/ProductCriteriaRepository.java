package com.marcelo.mystore.searchingEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.marcelo.mystore.entity.Product;
import com.marcelo.mystore.repository.ProductRepository;

@Repository
public class ProductCriteriaRepository {
	
	private final EntityManager entityManager;
	private final CriteriaBuilder criteriaBuilder;
	
	public ProductCriteriaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.criteriaBuilder = entityManager.getCriteriaBuilder();
	}
	
	public Page<Product> findAllWithFilters(ProductPage productPage, 
											ProductSearchCriteria productSearchCriteria){
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> productRoot = criteriaQuery.from(Product.class);
		Predicate predicate = getPredicate(productSearchCriteria, productRoot);
		criteriaQuery.where(predicate);
		TypedQuery<Product> typedQuery = entityManager.createQuery(criteriaQuery);
		
		typedQuery.setFirstResult(productPage.getPageNumber()* productPage.getPageSize());
		typedQuery.setMaxResults(productPage.getPageSize());
		
		Pageable pageable = getPageable(productPage);
		long productsCount = getProductsCount(predicate);
		
		return new PageImpl<>(typedQuery.getResultList(), pageable, productsCount);
	}

	

	private Predicate getPredicate(ProductSearchCriteria productSearchCriteria, 
									Root<Product> productRoot) {
		List<Predicate>predicates = new ArrayList<>();
		if(Objects.nonNull(productSearchCriteria.getBrand())) {
			predicates.add(
					criteriaBuilder.like(productRoot.get("brand"),"%"+ productSearchCriteria.getBrand() + "%")
					);
		}
		if(Objects.nonNull(productSearchCriteria.getDescription())) {
			predicates.add(
					criteriaBuilder.like(productRoot.get("description"),"%"+ productSearchCriteria.getDescription() + "%")
					);
		}
		if(Objects.nonNull(productSearchCriteria.getPriceMax())) {
			predicates.add(
			criteriaBuilder.between(productRoot.get("price"), productSearchCriteria.getPriceMin(), productSearchCriteria.getPriceMax()));
		}
		
		if(Objects.nonNull(productSearchCriteria.getMaterials())) {
			predicates.add(
					criteriaBuilder.in(productRoot.get("material")).value(productSearchCriteria.getMaterials())
					);
		}
		if(Objects.nonNull(productSearchCriteria.getSizes())) {
			predicates.add(
					criteriaBuilder.in(productRoot.get("size")).value(productSearchCriteria.getSizes())
					);
		}
			
		
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
	
	private Pageable getPageable(ProductPage productPage) {
		
		return PageRequest.of(productPage.getPageNumber(), productPage.getPageSize(), Direction.ASC, "sku");
	}

	private long getProductsCount(Predicate predicate) {
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		Root<Product> countRoot = countQuery.from(Product.class);
		countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
		return entityManager.createQuery(countQuery).getSingleResult();
	}

}
