package com.jspiders.controller;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class BillingAddress implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private String street;
    private String city;
 
    BillingAddress() {}
 
    public BillingAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }
 
    public String getStreet() {
        return street;
    }
 
    private void setStreet(String street) {
        this.street = street;
    }
 
    public String getCity() {
        return city;
    }
 
    private void setCity(String city) {
        this.city = city;
    }
}
