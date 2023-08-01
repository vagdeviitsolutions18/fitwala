package com.vagdeviitsol.fitwala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vagdeviitsol.fitwala.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	
}
