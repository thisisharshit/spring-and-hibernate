package com.harshit.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harshit.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	
	// define field for entitymanager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	//@Transactional //dont need to start and commit the transsaction manually
	// removing because of adding EmployeeService interface
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//SessionFactory sessionFactory=session.getOpenSessions();
		//create a query
		Query<Employee> query=  (currentSession).createQuery("from Employee",Employee.class);
		
		//execute the query and get result list
		List<Employee> employees=query.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		//get the current hibernate session
		Session currenSession=entityManager.unwrap(Session.class);
		
		//get the employee
		Employee employee = currenSession.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee); //if id is zero then insert/save else update
	}

	@Override
	public void deleteById(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query query=currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
