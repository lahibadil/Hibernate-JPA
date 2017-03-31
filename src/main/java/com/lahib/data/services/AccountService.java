package com.lahib.data.services;

import com.lahib.data.entities.Account;
import com.lahib.data.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Adil on 3/26/2017.
 */
@Service
public class AccountService implements MyService<Account>{
    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }

    public Account update(Account account){
        return save(account);
    }

    public void delete(Account account){
        accountRepository.delete(account);
    }

    public void delete(long id){
        accountRepository.delete(id);
    }

    public Account findOne(long id){
        return accountRepository.findOne(id);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }


}