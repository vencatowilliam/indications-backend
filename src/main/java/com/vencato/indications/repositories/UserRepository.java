package com.vencato.indications.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencato.indications.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByDocument(String document);
	Optional<User> findByEmail(String email);
	
}
