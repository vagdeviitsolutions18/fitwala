package com.vagdeviitsol.fitwala;

import java.util.List;

import java.util.Optional;

public interface UserService {

	Users addDetails(Users user);

	Optional<Users> getUserById(Long id);

	Users updateUser(Long id, Users user);
	
	List<Users> getUsers(String searchQuery);

}
