package com.bco.bankApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bco.bankApp.model.Client;
import com.bco.bankApp.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/")
	public ResponseEntity<List<Client>> getClients() {
		try {
			List<Client> clients = new ArrayList<Client>();
			clients=clientRepository.findAll();
			if (clients.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(clients, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@PostMapping("/create")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		try {
			Client _client = clientRepository.save(client);
			return new ResponseEntity<>(_client, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/modify")
	public ResponseEntity<Client> modify(@RequestParam("id") Long id, @RequestBody Client client) {
		Optional<Client> clientData = clientRepository.findById(id);

		if (clientData.isPresent()) {
			Client _client = clientData.get();
			_client.setClienteId(client.getClienteId());
			_client.setNombre(client.getNombre());
			_client.setDireccion(client.getDireccion());
			_client.setTelefono(client.getTelefono());
			_client.setContrasena(client.getContrasena());
			_client.setEstado(client.getEstado());
			return new ResponseEntity<>(clientRepository.save(_client), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<HttpStatus> delete(@RequestParam("id") Long id) {
		try {
			clientRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}





}