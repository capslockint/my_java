package com.hamza.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.hamza.demo.dao.StudentDAO;
import com.hamza.demo.dao.StudentDAOImpl;
import com.hamza.demo.entity.Student;

@SpringBootApplication
public class Demo32Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Demo32Application.class, args);
	}

	@Autowired
	StudentDAO studentDAO;


		@Override
		public void run(String... args) throws Exception {

			System.out.println("creating new student object.....");
			Student tempStudent = new Student("hamza","alvi","hamzalvi754@gmail.com");
		// save the student object
			System.out.println("saving the studenet...."); 
			studentDAO.save(tempStudent);

	    // display id of the new student
			System.out.println("saved student. generated id:" + tempStudent.getId());
						
		}

}
