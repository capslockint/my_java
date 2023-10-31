package com.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
//	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	
	List<Course> list;
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(32,"sprinboot", "it is fun to lurn"));
		list.add(new Course(43,"java", "it is fun to practice"));

	}

	@Override
	public List<Course> getCoures() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course  c = null;
		for (Course course:list)
		{
		if(course.getId()==courseId)
		{
			c=course;
			break;
		}
	}
		return c;

}

	@Override
	public Course addCourse(Course course) {
        list.add(course);
		return course;
	}

	@Override
	public Course putCourse(Course course) {
		list.add(course);
		return course;
	}

	
    
    @Override
	public boolean deletCourse(long courseId) { 
    	System.out.println("List"+ list.toString());
    	
		for (Course course:list)
		{
		if(course.getId()==courseId)
		{
			list.remove(course);
	    	System.out.println("List After removing."+ list.toString());
	    	return true;
		}
	}
		return false;
	}

	
}
