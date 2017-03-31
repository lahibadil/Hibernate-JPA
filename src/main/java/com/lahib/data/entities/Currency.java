package com.lahib.data.entities;

import com.lahib.data.entities.ids.CurrencyId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adil on 3/18/2017.
 */

@Entity
@Table(name = "currency")
@IdClass(CurrencyId.class)
public class Currency implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NAME")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "COUNTRY_NAME")
    private String country;

    @Column(name = "SYMBOL")
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
