package com.lahib.data.services;

import com.lahib.data.entities.TransactionType;
import com.lahib.data.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class TransactionTypeService implements MyService<TransactionType> {
    
    @Autowired
    private TransactionTypeRepository repository;
    public TransactionType save(TransactionType entity) {
        return repository.saveAndFlush(entity);
    }

    public TransactionType update(TransactionType entity) {
        return save(entity);
    }


    public void delete(TransactionType entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public TransactionType findOne(long id) {
        return repository.findOne(id);
    }

    public List<TransactionType> findAll() {
        return repository.findAll();
    }
}
