package com.vagdeviitsol.fitwala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FitwalaService {
	
	@Autowired
	private FRepository FitwalaRepo;
	
	
	public FUsers addDetails(FUsers user) {
		
		return FitwalaRepo.save(user);
	}
}