package com.jspiders.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.dto.RegistrationDTO;

@Repository
public class RegistrationDAO {
@Autowired
private SessionFactory factory;

public boolean save(RegistrationDTO dto){
	System.out.println("inside Save method of DAO");
	boolean flag=false;
		System.out.println(dto);
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		try{
			tx.begin();
			session.save(dto);
			tx.commit();
			flag=true;
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
			flag=false;
		}finally{
			session.close();
		}
		
	return flag;
}
}
