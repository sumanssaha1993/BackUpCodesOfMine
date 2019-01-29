package com.jspiders.model.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.dto.AccountEntity;
import com.jspiders.dto.EmployeeEntity;

@Repository
public class RegistrationDAO {
	@Autowired
	private SessionFactory factory;

	public boolean save() {
		System.out.println("inside Save method of DAO..............");
		boolean flag = false;
		// System.out.println(dto);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.begin();

			AccountEntity account1 = new AccountEntity();
			account1.setAccountNumber("Account detail 1");

			AccountEntity account2 = new AccountEntity();
			account2.setAccountNumber("Account detail 2");

			AccountEntity account3 = new AccountEntity();
			account3.setAccountNumber("Account detail 3");

			// Add new Employee object
			EmployeeEntity firstEmployee = new EmployeeEntity();
			firstEmployee.setEmail("demo-user-first@mail.com");
			firstEmployee.setFirstName("demo-one");
			firstEmployee.setLastName("user-one");

			EmployeeEntity secondEmployee = new EmployeeEntity();
			secondEmployee.setEmail("demo-user-second@mail.com");
			secondEmployee.setFirstName("demo-two");
			secondEmployee.setLastName("user-two");

			Set<AccountEntity> accountsOfFirstEmployee = new HashSet<AccountEntity>();
			accountsOfFirstEmployee.add(account1);
			accountsOfFirstEmployee.add(account2);

			Set<AccountEntity> accountsOfSecondEmployee = new HashSet<AccountEntity>();
			accountsOfSecondEmployee.add(account3);

			firstEmployee.setAccounts(accountsOfFirstEmployee);
			secondEmployee.setAccounts(accountsOfSecondEmployee);

			session.save(firstEmployee);
			session.save(secondEmployee);

			tx.commit();
			flag = true;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			flag = false;
		} finally {
			session.close();
		}

		return flag;

	}

}
