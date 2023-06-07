package com.vagdeviitsol.fitwala;

import java.util.List;
import java.util.Optional;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository FitwalaRepo;
	
	@Autowired
	private SearchRepositroy searchRepositroy;

	@Override
	public Optional<Users> getUserById(Long id) {
		return FitwalaRepo.findById(id);
	}

	public Users addDetails(Users user) {

		return FitwalaRepo.save(user);

	}

	public Users updateUser(Long id, Users user) {
		Optional<Users> optionalUser = FitwalaRepo.findById(id);
		Users existingUser = null;
		if (optionalUser.isPresent()) {
			existingUser = optionalUser.get();
			existingUser.setFistName(user.getFistName());
			existingUser.setLastName(user.getLastName());
			existingUser.setEmail(user.getEmail());
			existingUser.setMobileNo(user.getMobileNo());
			existingUser.setGender(user.getGender());
			existingUser.setAge(user.getAge());
			existingUser.setAddress(user.getAddress());
			existingUser.setGymName(user.getGymName());
			existingUser.setPlanType(user.getPlanType());

		} else {
			throw new RuntimeException("User not found");
		}
		return FitwalaRepo.save(existingUser);
	}

	@Override
	public List<Users> getUsers(String searchQuery) {
		String SELECT_GET_USER="SELECT * FROM fitwalaproject.customers where 1=1 ";
		JSONParser jsonParser=new JSONParser(); 
		try {
			JSONObject json = (JSONObject) jsonParser.parse(searchQuery);
			System.out.println("firstname:"+json.get("fist_name"));
			System.out.println("pla_type:"+json.get("planType"));
			
			if(json.get("fistName") !=null) {
				SELECT_GET_USER=SELECT_GET_USER+" and fist_name like '%"+json.get("fistName")+"%'";
			}
			if(json.get("planType")!=null) {
				SELECT_GET_USER=SELECT_GET_USER+"and plan_type like '%"+json.get("planType")+"%'";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return searchRepositroy.getUsers(SELECT_GET_USER);
	} 
}