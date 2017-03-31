package com.lahib.data.services;

import com.lahib.data.entities.Transaction;
import com.lahib.data.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class TransactionService implements MyService<Transaction> {
    
    @Autowired
    private TransactionRepository repository;
    public Transaction save(Transaction entity) {
        return repository.saveAndFlush(entity);
    }

    public Transaction update(Transaction entity) {
        return save(entity);
    }


    public void delete(Transaction entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Transaction findOne(long id) {
        return repository.findOne(id);
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }
}
