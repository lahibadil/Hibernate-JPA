package com.lahib.data.services;

import com.lahib.data.entities.Bond;
import com.lahib.data.repositories.BondRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class BondService implements MyService<Bond> {
    @Autowired
    private BondRepository repository;
    public Bond save(Bond entity) {
        return repository.saveAndFlush(entity);
    }

    public Bond update(Bond entity) {
        return save(entity);
    }


    public void delete(Bond entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public Bond findOne(long id) {
        return repository.findOne(id);
    }

    public List<Bond> findAll() {
        return repository.findAll();
    }
}
