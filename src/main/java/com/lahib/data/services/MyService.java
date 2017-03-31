package com.lahib.data.services;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
public interface MyService<T> {

    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void delete(long id);
    T findOne(long id);
    List<T> findAll();
}
