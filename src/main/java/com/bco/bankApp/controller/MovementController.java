package com.bco.bankApp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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


import com.bco.bankApp.model.Movement;
import com.bco.bankApp.repository.MovementRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/movimientos")
public class MovementController {

	@Autowired
	MovementRepository movementRepository;
	

	@GetMapping("/")
	public ResponseEntity<List<Movement>> getMovements() {
		try {
			List<Movement> movements = new ArrayList<Movement>();
			movements=movementRepository.findAll();
			if (movements.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(movements, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@PostMapping("/create")
	public ResponseEntity<Movement> create(@RequestBody Movement movement) {
		try {
			
			Movement _movement = movementRepository.save(movement);
			return new ResponseEntity<>(_movement, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/modify/{id}")
	public ResponseEntity<Movement> modify(@PathVariable("id") long id, @RequestBody Movement movement) {
		Optional<Movement> movementData = movementRepository.findById(id);

		if (movementData.isEmpty()) {
			Movement _movement = movementData.get();
			_movement.setMovementId(movement.getMovementId());
			_movement.setClientId(movement.getClientId());
			_movement.setEstado(movement.getEstado());
			_movement.setNumeroCuenta(movement.getNumeroCuenta());
			_movement.setMovimiento(movement.getMovimiento());
			_movement.setSaldoDisponible(movement.getSaldoDisponible());
			return new ResponseEntity<>(movementRepository.save(_movement), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			movementRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<List<Movement>> getReport(
	        @RequestParam("beginDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date beginDate,
	        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
	        @RequestParam("clientId") String clientId) {
	    try {
	        List<Movement> reportList = movementRepository.getReport(beginDate, endDate, clientId);
	        if (reportList.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(reportList, HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}





}