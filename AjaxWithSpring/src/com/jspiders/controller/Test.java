package com.jspiders.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {
	
	private static SessionFactory factory;

	public static void main(String[] args) {
		
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("jspiders.cfg.xml").build();  
		    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction tx = session.beginTransaction();   
		     
		tx.begin();
		 
		PurchaseOrder purchaseOrder = 
		  new PurchaseOrder(new BillingAddress("Broad Street", "Boston"));
		purchaseOrder.setItemName("My new computer");
		session.save(purchaseOrder); 
		 
		tx.commit();
		factory.close();  
	    session.close();   
	}
}
