package com.jspiders.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.dto.foodDTO;

@Repository
public class foodDAO {
	@Autowired
	private SessionFactory factory;

	public foodDTO get(String foodid) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		foodDTO food = null;
		try {
			tx.begin();
			food = session.get(foodDTO.class, foodid);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return food;
	}

}
