package com.lahib.data.services;

import com.lahib.data.entities.Portfolio;
import com.lahib.data.repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class PortfolioService implements MyService<Portfolio> {
    
    @Autowired
    private PortfolioRepository repository;
    public Portfolio save(Portfolio entity) {
        return repository.saveAndFlush(entity);
    }

    public Portfolio update(Portfolio entity) {
        return save(entity);
    }


    public void delete(Portfolio entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Portfolio findOne(long id) {
        return repository.findOne(id);
    }

    public List<Portfolio> findAll() {
        return repository.findAll();
    }
}
