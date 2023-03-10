package com.bco.bankApp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bco.bankApp.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
