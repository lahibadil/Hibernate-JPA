package com.lahib.data.entities;

import javax.persistence.*;

/**
 * Created by Adil on 3/18/2017.
 */

@Entity
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARKET_ID")
    private long id;

    @Column(name = "MARKET_NAME")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "CURRENCY_NAME", referencedColumnName = "NAME"),
            @JoinColumn(name = "COUNTRY_NAME", referencedColumnName = "COUNTRY_NAME")
    })
    private Currency currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
