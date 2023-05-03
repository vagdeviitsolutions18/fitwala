package com.vagdeviitsol.fitwala;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository FitwalaRepo;

	@Override
	public Optional<Users> getUserById(Long id) {
		return FitwalaRepo.findById(id);
	}

	public Users addDetails(Users user) {

		return FitwalaRepo.save(user);

	}

	@Override
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
}