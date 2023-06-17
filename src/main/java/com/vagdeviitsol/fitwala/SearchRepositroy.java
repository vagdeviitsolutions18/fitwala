package com.vagdeviitsol.fitwala;


import java.util.List;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SearchRepositroy{
	
	@PersistenceContext
	EntityManager entityManager;

	List<Users> getUsers(String SELECT_QUERY){
		 List<Users> list = (List<Users>) entityManager.createNativeQuery(SELECT_QUERY).getResultList();
		 return list; 
		}
}
