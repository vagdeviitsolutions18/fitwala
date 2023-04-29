package com.vagdevitisol.fitwala.lingeswar.FitwalaProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitwalaService {
	
	@Autowired
	private FitwalaRepository FitwalaRepo;
	
	
	public User addDetails(User user) {
		
		return FitwalaRepo.save(user);
	}
//	public List<User> saveDetails(List<User> user)
//	{
//		return FitwalaRepo.saveAll(user);
//	}
//	public List<User> getDetails(){
//		
//		return FitwalaRepo.findAll();
//	}
//	public List<User> getUserByFistName(String fistname)
//	{
//		return  FitwalaRepo.findByFistName(fistname);
//	}
//	public String deleteDetails(String fistname) {
//		
//		FitwalaRepo.deleteByFistName(fistname);
//		return "User removed !!"+fistname;
//	}
	public User updateDetails(User user) {
		
		User existingDetails=FitwalaRepo.findById(user.getId()).orElse(user);
		existingDetails.setfistName(user.getfistName());
		existingDetails.setlastName(user.getlateName());
		existingDetails.setemailID(user.getemailID());
		existingDetails.setmobileNo(user.getmobileNo());
		existingDetails.setgender(user.getgender());
		existingDetails.setaddress(user.getaddress());
		existingDetails.setage(user.getage());
		existingDetails.setGymName(user.getGymName());
		existingDetails.setplanType(user.getplanType());
		
		return FitwalaRepo.save(existingDetails);
	}

}
