package com.harshit.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harshit.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;  //there is a bean id of this name in config file
	
	@Override
	//@Transactional removing this because of service layer
	public List<Customer> getCustomers() {
		//get the currrent hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create the query...sort by last name
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by lastName",Customer.class); 
		
		//execute query and get results list
		List<Customer> customers=theQuery.getResultList();
		
		//return the results
		return customers;
		
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get current hibernate sesssion
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save/update the customer
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomers(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		//read  from DB using the primary key id
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query theQuery=currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
		
	}

}
