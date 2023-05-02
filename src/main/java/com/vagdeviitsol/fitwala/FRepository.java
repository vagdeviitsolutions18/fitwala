package com.vagdeviitsol.fitwala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FRepository extends JpaRepository<FUsers,Long>{
	
	
}
    
