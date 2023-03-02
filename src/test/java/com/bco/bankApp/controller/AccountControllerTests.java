package com.bco.bankApp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.bco.bankApp.model.Account;
import com.bco.bankApp.repository.AccountRepository;


@SpringBootTest
public class AccountControllerTests {

    @Autowired
    private AccountController accountController;

    @MockBean
    private AccountRepository accountRepository;

    private List<Account> accountList;

    @Before
    public void setUp() {
        accountList = new ArrayList<>();
        accountList.add(new Account(1L, 123123L, "cuenta1", "1000", "activo", "cliente1"));
        accountList.add(new Account(2L, 1231312L , "cuenta2", "2000", "inactivo", "cliente2"));
    }

    @Test
    public void returnsNoAccount() {
        Mockito.when(accountRepository.findAll()).thenReturn(Collections.emptyList());
        ResponseEntity<List<Account>> response = accountController.getClients();
        Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }



    @Test
    public void returnAValidAccountAndCreate() {
        Account account = new Account(1L, 123123L, "cuenta1", "1000", "activo", "cliente1");
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        ResponseEntity<Account> response = accountController.createAccount(account);
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals(account, response.getBody());
    }

    @Test
    public void returnAnInternalServerWhenCreateUser() {
        Account account = new Account(1L, 123123L, "cuenta1", "1000", "activo", "cliente1");
        Mockito.when(accountRepository.save(account)).thenThrow(new IllegalArgumentException());
        ResponseEntity<Account> response = accountController.createAccount(account);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Assert.assertNull(response.getBody());
    }

 

   

   

}
