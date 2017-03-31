package com.lahib.data.repositories;

import com.lahib.data.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adil on 3/23/2017.
 */
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
