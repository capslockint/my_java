package com.hamza.springrest.demo.service;

import java.util.List;

import com.hamza.springrest.demo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(int theId);
	Employee save(Employee theEmployee);
	void deletById(int theId);

}
