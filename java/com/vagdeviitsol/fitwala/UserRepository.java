package com.vagdeviitsol.fitwala;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Search, Long>, JpaSpecificationExecutor<Search> {

	List<Search> FindAll();
}
