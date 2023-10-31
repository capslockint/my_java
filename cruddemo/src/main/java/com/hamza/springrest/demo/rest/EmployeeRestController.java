package com.hamza.springrest.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamza.springrest.demo.entity.Employee;
import com.hamza.springrest.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	//quick and dirty . inject employee DAO (use constructor injection)
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employee" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null)
		{
			throw new RuntimeException("Employee id not found" + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;

	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deletEmployee(@PathVariable int employeeId){
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null)
		{
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deletById(employeeId);
		
		return "Delete employee id - " + employeeId;
	}
}
