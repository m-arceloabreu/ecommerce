package com.marcelo.mystore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestBody;
import com.marcelo.mystore.DTO.ClientDTO;
import com.marcelo.mystore.entity.Client;
import com.marcelo.mystore.repository.ClientRepository;
import com.marcelo.mystore.service.ClientService;
import com.marcelo.mystore.utils.RegionUtils;

@RestController
@RequestMapping("/client")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ClientController {

	@Autowired
	public ClientRepository clientRepository;
	@Autowired
	public RegionUtils regionService;
	@Autowired
	ClientService clientService;

	@PostMapping("/")
	public ResponseEntity<Client> saveClient(@RequestBody @Valid ClientDTO clientDTO) {
		if (clientRepository.existsByCpf(clientDTO.getCpf()) == true) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This CPF is already registred");
		}
		String region = regionService.locateRegion(clientDTO.getResidencialAddress().getState());
		clientDTO.getResidencialAddress().setRegion(region);
		if (clientDTO.getBusinessAddress() != null) {
			String businessRegion = regionService.locateRegion(clientDTO.getBusinessAddress().getBusinessState());
			clientDTO.getBusinessAddress().setBusinessRegion(businessRegion);
		}
		Client client = new Client();
		BeanUtils.copyProperties(clientDTO, client);
		clientService.saveClient(client);
		return new ResponseEntity<>(client, HttpStatus.CREATED);
	}
	
	@PutMapping("/{cpf}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "cpf") String cpf, @RequestBody @Valid ClientDTO clientDTO){
		clientDTO.setCpf(cpf);
		Client clientUpdated = clientService.checkByCpfInDataBase(cpf);
		BeanUtils.copyProperties(clientDTO, clientUpdated);
		
		return ResponseEntity.status(HttpStatus.OK).body(clientService.saveClient(clientUpdated));
	}
	@DeleteMapping("/delete/{cpf}")
	public void deleteByCpf(@PathVariable(value= "cpf") String cpf) {
		clientService.deleteByCpf(cpf);
	}
	
	@GetMapping("/{pageQtd}")
	public ResponseEntity<Page<Client>> getAllClients(@PathVariable(value= "pageQtd") Integer pageQtd){
		Page<Client> clients = clientService.getAll(pageQtd);
		return ResponseEntity.ok(clients);
	}
}
