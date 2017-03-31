package com.lahib.data.services;

import com.lahib.data.entities.Bank;
import com.lahib.data.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class BankService implements MyService<Bank> {
    
    @Autowired
    private BankRepository repository;
    public Bank save(Bank entity) {
        return repository.saveAndFlush(entity);
    }

    public Bank update(Bank entity) {
        return save(entity);
    }


    public void delete(Bank entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Bank findOne(long id) {
        return repository.findOne(id);
    }

    public List<Bank> findAll() {
        return repository.findAll();
    }
}
