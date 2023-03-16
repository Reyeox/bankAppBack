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

import com.bco.bankApp.model.Account;
import com.bco.bankApp.repository.AccountRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/cuentas")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/")
	public ResponseEntity<List<Account>> getAccounts() {
		try {
			List<Account> accounts = new ArrayList<Account>();
			accounts=accountRepository.findAll();
			if (accounts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(accounts, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		try {
			Account _account = accountRepository.save(account);
			return new ResponseEntity<>(_account, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/modify")
	public ResponseEntity<Account> modify(@RequestParam("id") Long id, @RequestBody Account account) {
		Optional<Account> accountData = accountRepository.findById(id);

		if (accountData.isEmpty()) {
			Account _account = accountData.get();
			_account.setNumeroCuenta(account.getNumeroCuenta());
			_account.setTipoCuenta(account.getTipoCuenta());
			_account.setSaldoInicial(account.getSaldoInicial());
			_account.setClientId(account.getClientId());
			_account.setEstado(account.getEstado());
		
			return new ResponseEntity<>(accountRepository.save(_account), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<HttpStatus> delete(@RequestParam("id") Long id) {
		try {
			accountRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}





}