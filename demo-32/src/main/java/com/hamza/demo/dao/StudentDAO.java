package com.hamza.demo.dao;

import org.springframework.stereotype.Repository;

import com.hamza.demo.entity.Student;

@Repository
public interface StudentDAO {
	
	void save(Student theStudent);

}
