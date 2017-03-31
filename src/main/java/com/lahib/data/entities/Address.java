package com.lahib.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Adil on 3/15/2017.
 */
@Embeddable
public class Address {
    @Column(name = "ADDRESS_LINE_1")
    private String line1;

    @Column(name = "ADDRESS_LINE_2")
    private String line2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
