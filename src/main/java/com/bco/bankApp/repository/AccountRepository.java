package com.bco.bankApp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.bco.bankApp.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	
	
}
