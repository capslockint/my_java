package com.hamza.springrest.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hamza.springrest.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	
	// define field for entity manager
	private EntityManager entityManager;
	
	// set up cocstructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
		
	}
	@Override
	public List<Employee> findAll() {
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//execute query and get results 

		List<Employee> employees = theQuery.getResultList();
		
		//return he results
		
		return employees;
		
	}
	@Override
	public Employee findById(int theId) {
  
		// get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		//return emplyee
		return theEmployee;
	}
	@Override
	public Employee save(Employee theEmployee) {
		//  save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		// return employee
		return dbEmployee;
	}
	@Override
	public void deletById(int theId) {
		// find employee by id
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		entityManager.remove(theEmployee);
		
	}

}
