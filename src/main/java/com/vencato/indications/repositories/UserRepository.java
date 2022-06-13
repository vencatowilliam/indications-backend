package com.vencato.indications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vencato.indications.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
