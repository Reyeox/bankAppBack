package com.bco.bankApp.controller;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bco.bankApp.model.Client;
import com.bco.bankApp.repository.ClientRepository;
@SpringBootTest
public class ClientControllerTests {
	
	   @Autowired
	    private ClientController clientController;

	    @MockBean
	    private ClientRepository clientRepository;
	    
	    
	  @Test
	    public void returnNoClients() {
	        Mockito.when(clientRepository.findAll()).thenReturn(Collections.emptyList());
	        ResponseEntity<List<Client>> response = clientController.getClients();
	        Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	    }



	    @Test
	    public void returnAValidClientAndCreate() {
	    	Client account = new Client(1L, "Eduardo", "CL 2", "12345", "123", true);
	        Mockito.when(clientRepository.save(account)).thenReturn(account);
	        ResponseEntity<Client> response = clientController.createClient(account);
	        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        Assert.assertEquals(account, response.getBody());
	    }

	    @Test
	    public void returnAnInternalServerWhenCreateClient() {
	    	Client account = new Client(1L, "Eduardo", "CL 2", "12345", "123", true);
	        Mockito.when(clientRepository.save(account)).thenThrow(new IllegalArgumentException());
	        ResponseEntity<Client> response = clientController.createClient(account);
	        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	        Assert.assertNull(response.getBody());
	    }
}
