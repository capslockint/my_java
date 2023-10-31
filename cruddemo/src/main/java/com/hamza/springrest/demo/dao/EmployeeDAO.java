package com.hamza.springrest.demo.dao;

import java.util.List;

import com.hamza.springrest.demo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
	
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deletById(int theId);
 
}
