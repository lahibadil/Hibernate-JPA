package com.lahib.data.services;

import com.lahib.data.entities.Currency;
import com.lahib.data.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class CurrencyService implements MyService<Currency> {
    
    @Autowired
    private CurrencyRepository repository;
    public Currency save(Currency entity) {
        return repository.saveAndFlush(entity);
    }

    public Currency update(Currency entity) {
        return save(entity);
    }


    public void delete(Currency entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Currency findOne(long id) {
        return repository.findOne(id);
    }

    public List<Currency> findAll() {
        return repository.findAll();
    }
}
