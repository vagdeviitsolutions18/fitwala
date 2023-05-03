package com.vagdeviitsol.fitwala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired

	private UserServiceImp service;
	@Autowired
	private UserRepository FitwalaRepo;

	@PostMapping("/addUser")
	public Users postDetails(@RequestBody Users user) {
		return service.addDetails(user);
	}

	@PutMapping("/{userid}")
	public ResponseEntity<?> updateUser(@PathVariable Long userid, @RequestBody Users updatedUser) {

		Users user = service.updateUser(userid, updatedUser);

		return ResponseEntity.ok().body("{\"status\": \"success\"}");

	}
	@GetMapping("/users")
	public List<Users> getAllUsers() {
	    return FitwalaRepo.findAll();
	}
//	@GetMapping("/users")
//    public User getUserDetails(@RequestParam("firstName") String firstName, 
//                               @RequestParam("lastName") String lastName,
//                               @RequestParam("age") int age) {
//        return FitwalaRepo.findByFirstNameAndLastNameAndAge(firstName, lastName, age)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
//    }

}