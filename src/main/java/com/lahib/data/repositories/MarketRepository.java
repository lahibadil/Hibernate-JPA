package com.lahib.data.repositories;

import com.lahib.data.entities.Market;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adil on 3/23/2017.
 */
public interface MarketRepository extends JpaRepository<Market, Long> {
}
