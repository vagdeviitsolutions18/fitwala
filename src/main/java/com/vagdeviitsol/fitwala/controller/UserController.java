 package com.vagdeviitsol.fitwala.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vagdeviitsol.fitwala.model.Users;
import com.vagdeviitsol.fitwala.repository.UserRepository;
import com.vagdeviitsol.fitwala.service.UserServiceImp;

@RestController
public class UserController {
	@Autowired

	private UserServiceImp service;
	@Autowired
	private UserRepository FitwalaRepo;

	@PostMapping("/v1/addUser")
	public Users postDetails(@RequestBody Users user) {

		return service.addDetails(user);
	}

	@GetMapping("/Javalog")
	public String java() {
		return " Hello log4j!!.. ";
	}

	@PutMapping("/v1/{userid}")
	public Users updateUser(@PathVariable Long userid, @RequestBody Users updatedUser) {


		Users user = service.updateUser(userid, updatedUser);

		System.out.println("Users data is : " + user);

		return user;
		//ResponseEntity.ok().body("{\"status\": \"success\"}");

	}

	@GetMapping("/v1/users")
	public List<Users> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/v1/searchusers")
	public List<Users> getUsers(@RequestBody String str) {
		System.out.println("str: ");
		return service.getUsers(str);
	}

}