package com.lahib.data.repositories;

import com.lahib.data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adil on 3/22/2017.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
