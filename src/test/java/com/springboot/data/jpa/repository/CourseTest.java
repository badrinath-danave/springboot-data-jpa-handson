package com.springboot.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.data.jpa.entity.Course;

@SpringBootTest
public class CourseTest {

	@Autowired
	private CourseRepository repository;
	
	@Test
	public void displayCourse() {
		List<Course> courseList = repository.findAll();
	}
	
}
