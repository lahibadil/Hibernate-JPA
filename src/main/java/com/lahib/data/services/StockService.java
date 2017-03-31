package com.lahib.data.services;

import com.lahib.data.entities.Stock;
import com.lahib.data.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class StockService implements MyService<Stock> {
    
    @Autowired
    private StockRepository repository;
    public Stock save(Stock entity) {
        return repository.saveAndFlush(entity);
    }

    public Stock update(Stock entity) {
        return save(entity);
    }


    public void delete(Stock entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Stock findOne(long id) {
        return repository.findOne(id);
    }

    public List<Stock> findAll() {
        return repository.findAll();
    }
}
