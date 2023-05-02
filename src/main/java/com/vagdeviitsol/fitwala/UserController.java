package com.vagdeviitsol.fitwala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FController {
	@Autowired
	 //FitwalaRepository fitwalaRepo;
     // User user ;
	private FitwalaService service;
	
	
	@PostMapping("/addUser")
	public FUsers postDetails(@RequestBody FUsers user) 
	{
		return service.addDetails(user);
	}
	
	// naveen code
}