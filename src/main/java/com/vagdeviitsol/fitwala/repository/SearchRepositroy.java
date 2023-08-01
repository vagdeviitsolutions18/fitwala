package com.vagdeviitsol.fitwala.repository;


import java.util.List;
import org.springframework.stereotype.Repository;

import com.vagdeviitsol.fitwala.model.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SearchRepositroy {
    @PersistenceContext
    EntityManager entityManager;

    public List<Users> getUsers(String SELECT_QUERY) {
        List<Users> list = (List<Users>) entityManager.createNativeQuery(SELECT_QUERY).getResultList();
        return list;
    }
}

