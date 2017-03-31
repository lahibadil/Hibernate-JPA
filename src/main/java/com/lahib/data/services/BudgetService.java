package com.lahib.data.services;

import com.lahib.data.entities.Budget;
import com.lahib.data.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class BudgetService implements MyService<com.lahib.data.entities.Budget> {
    @Autowired
    private BudgetRepository repository;
    public Budget save(Budget entity) {
        return repository.saveAndFlush(entity);
    }

    public Budget update(Budget entity) {
        return save(entity);
    }


    public void delete(Budget entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Budget findOne(long id) {
        return repository.findOne(id);
    }

    public List<Budget> findAll() {
        return repository.findAll();
    }
}
