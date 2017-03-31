package com.lahib.data.services;

import com.lahib.data.entities.User;
import com.lahib.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public class UserService implements MyService<User> {
    
    @Autowired
    private UserRepository repository;
    public User save(User entity) {
        return repository.saveAndFlush(entity);
    }

    public User update(User entity) {
        return save(entity);
    }


    public void delete(User entity) {
        repository.delete(entity);
    }

    public void delete(long id) {
        repository.delete(id);
    }

    public User findOne(long id) {
        return repository.findOne(id);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
