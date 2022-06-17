package com.marcelo.mystore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.mystore.entity.Client;
import com.marcelo.mystore.entity.Product;
import com.marcelo.mystore.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	private List<Client> clients = new ArrayList<Client>();
	
	@Transactional
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client checkByCpfInDataBase(String cpf) {
		if(clientRepository.findByCpf(cpf)== null) {
			throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "We could not find this CPF");
		}
		return clientRepository.findByCpf(cpf);
	}
	public void deleteByCpf(String cpf) {
		
		clientRepository.delete(clientRepository.findByCpf(cpf));
	}
	
	public Page<Client> getAll(Integer pageQtd) {
		Pageable pageable = PageRequest.of(0,pageQtd);
		Page<Client> clients = clientRepository.findAll(pageable);
		return clients;
	}
	
}
