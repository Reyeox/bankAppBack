package com.bco.bankApp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bco.bankApp.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

}
