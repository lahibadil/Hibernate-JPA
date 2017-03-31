package com.lahib.data.services;

import com.lahib.data.entities.Market;
import com.lahib.data.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class MarketServcice implements MyService<Market> {
    
    @Autowired
    private MarketRepository repository;
    public Market save(Market entity) {
        return repository.saveAndFlush(entity);
    }

    public Market update(Market entity) {
        return save(entity);
    }


    public void delete(Market entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Market findOne(long id) {
        return repository.findOne(id);
    }

    public List<Market> findAll() {
        return repository.findAll();
    }
}
