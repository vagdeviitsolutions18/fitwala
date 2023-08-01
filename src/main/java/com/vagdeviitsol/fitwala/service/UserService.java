package com.vagdeviitsol.fitwala.service;

import java.util.List;

import java.util.Optional;

import com.vagdeviitsol.fitwala.model.Users;

public interface UserService {

	Users addDetails(Users user);

	Optional<Users> getUserById(Long id);

	Users updateUser(Long id, Users user);
	
	List<Users> getUsers(String searchQuery);

	List<Users> getAllUsers();

	
	}


