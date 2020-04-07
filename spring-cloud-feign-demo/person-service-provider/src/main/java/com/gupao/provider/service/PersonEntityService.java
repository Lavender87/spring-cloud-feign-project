package com.gupao.provider.service;

import com.gupao.provider.entity.PersonEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class PersonEntityService {

    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(PersonEntity personEntity){
        entityManager.persist(personEntity);
    }
}
