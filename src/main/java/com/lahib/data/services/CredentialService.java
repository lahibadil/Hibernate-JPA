package com.lahib.data.services;

import com.lahib.data.entities.Credential;
import com.lahib.data.repositories.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class CredentialService implements MyService<Credential> {
    
    @Autowired
    private CredentialRepository repository;
    public Credential save(Credential entity) {
        return repository.saveAndFlush(entity);
    }

    public Credential update(Credential entity) {
        return save(entity);
    }


    public void delete(Credential entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Credential findOne(long id) {
        return repository.findOne(id);
    }

    public List<Credential> findAll() {
        return repository.findAll();
    }
}
