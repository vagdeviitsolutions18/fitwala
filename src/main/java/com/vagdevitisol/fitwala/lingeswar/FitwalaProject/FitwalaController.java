package com.vagdevitisol.fitwala.lingeswar.FitwalaProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FitwalaController {
	@Autowired
	 //FitwalaRepository fitwalaRepo;
     // User user ;
	private FitwalaService service;
	
	
	@PostMapping("/addUser")
	public User postDetails(@RequestBody User user) 
	{
		return service.addDetails(user);
	}
	@GetMapping("/JavaGenie")
	public String test()
	{
		return "Hello Java Genie";
	}
	@PutMapping("/Update")
	public String updateDetails(@RequestBody User user)
	{
	       service.updateDetails(user);
	       return "Update is Success ";
	}
	
//	@PostMapping("/addUsers")
//    public List<User> addDetails(@RequestBody User user)
//    {
//    	return service.saveDetails((List<User>) user);
//    }
//	@GetMapping("/User")
//	public List<User> findAllDetails()
//	{
//		return service.getDetails();
//	}
//	@GetMapping("/Users")
//	public List<User> findUserByFistName(@PathVariable String fistname)
//	{
//		return service.getUserByFistName(fistname);
//	}
//	 
//	@DeleteMapping("/delete")
//	public String deleteDetails(@PathVariable String fistname)
//	{
//		return service.deleteDetails(fistname);
//	}
//	@PutMapping
//	public User putDetails(@RequestBody User user)
//	{
//		return fitwalaRepo.save(user);
//	}
//	@DeleteMapping
//	public User deleteDetails(@RequestBody User user)
//	{
//		return fitwalaRepo.save(user);
//	}
//	@GetMapping("/by-fistname")
//	public User findFistByName(@RequestParam String fistName)
//	{
//		return fitwalaRepo.findByFistName(fistName);
//	}

}
