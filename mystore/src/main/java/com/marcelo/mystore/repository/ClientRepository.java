package com.marcelo.mystore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.marcelo.mystore.entity.Client;


public interface ClientRepository extends PagingAndSortingRepository<Client, String> {

	boolean existsByCpf(String cpf);
	Client findByCpf(String cpf);


}
