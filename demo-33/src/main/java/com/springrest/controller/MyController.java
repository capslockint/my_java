package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Course;
import com.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	@GetMapping("/home")
	public String home() {
		return"this is home page";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseService.getCoures();
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
    
	@PutMapping("/courses")
	public Course putCourse(@RequestBody Course course)
	{
		return this.courseService.putCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public boolean deletCourse(@PathVariable Long courseId){
		return this.courseService.deletCourse(courseId);
				
	}
}
