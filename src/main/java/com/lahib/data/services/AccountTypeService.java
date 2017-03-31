package com.lahib.data.services;

import com.lahib.data.entities.AccountType;
import com.lahib.data.repositories.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */

@Service
public class AccountTypeService implements MyService<AccountType> {

    @Autowired
    private AccountTypeRepository repository;

    public AccountType save(AccountType entity) {
        return repository.saveAndFlush(entity);
    }

    public AccountType update(AccountType entity) {
        return save(entity);
    }

    public void delete(AccountType entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public AccountType findOne(long id) {
        return repository.findOne(id);
    }

    public List<AccountType> findAll() {
        return repository.findAll();
    }
}
