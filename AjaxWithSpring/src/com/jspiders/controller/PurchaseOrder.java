package com.jspiders.controller;
import javax.persistence.*;

@Entity
@Table(name = "PURCHASE_ORDERS")
@IdClass(BillingAddress.class)
public class PurchaseOrder {
	
	PurchaseOrder() {}
	 
    PurchaseOrder(BillingAddress billingAddress) {
    street = billingAddress.getStreet();
    city = billingAddress.getCity();
    }
 
    @Id
    @AttributeOverrides({
    @AttributeOverride(name = "street",
    column = @Column(name="STREET")),
    @AttributeOverride(name = "city",
    column = @Column(name="CITY"))
    })
 
    private String street;
    private String city;
    private String itemName;
 
    public String getItemName() {
    return itemName;
    }
 
    public void setItemName(String itemName) {
    this.itemName = itemName;
    }
}
