package com.bco.bankApp.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.bco.bankApp.model.Movement;

import com.bco.bankApp.repository.MovementRepository;
@SpringBootTest
public class MovementControllerTests {
	
	   @Autowired
	    private MovementController movementController;

	    @MockBean
	    private MovementRepository movementRepository;
	    
	    
	  @Test
	    public void returnsNoMovements() {
	        Mockito.when(movementRepository.findAll()).thenReturn(Collections.emptyList());
	        ResponseEntity<List<Movement>> response = movementController.getMovements();
	        Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	    }



	    @Test
	    public void returnAValidMovementAndCreate() {
	    	Movement account = new Movement(2L,2L,"Ahorro","2000","12",232323L,true,2000L,2000L, new Date());
	        Mockito.when(movementRepository.save(account)).thenReturn(account);
	        ResponseEntity<Movement> response = movementController.create(account);
	        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        Assert.assertEquals(account, response.getBody());
	    }

	    @Test
	    public void returnAnInternalServerWhenCreateMovement() {
	    	Movement account = new Movement(2L,2L,"Ahorro","2000","12",232323L,true,2000L,2000L, new Date());
	        Mockito.when(movementRepository.save(account)).thenThrow(new IllegalArgumentException());
	        ResponseEntity<Movement> response = movementController.create(account);
	        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	        Assert.assertNull(response.getBody());
	    }
}
