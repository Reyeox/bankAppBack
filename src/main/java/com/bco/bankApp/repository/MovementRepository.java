package com.bco.bankApp.repository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bco.bankApp.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

	  @Query("SELECT m FROM Movement m WHERE m.createDate >= :beginDate AND m.createDate <= :endDate AND m.clientId = :clientId")
	    List<Movement> getReport(Date beginDate, Date endDate, String clientId);

	
}
