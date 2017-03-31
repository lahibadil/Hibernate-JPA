package com.lahib.data.entities.ids;

import java.io.Serializable;

/**
 * Created by Adil on 3/18/2017.
 */
public class CurrencyId implements Serializable {

    private String name;
    private String country;

    public CurrencyId() {
    }

    public CurrencyId(String name, String country) {
        this.name = name;
        this.country = country;
    }

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
}
