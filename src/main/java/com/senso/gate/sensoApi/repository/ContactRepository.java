package com.senso.gate.sensoApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.senso.gate.sensoApi.model.Contact;;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
}

