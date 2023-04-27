package com.springboot.data.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.data.jpa.entity.Course;
import com.springboot.data.jpa.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository ;
	
	
	@Test
	public void saveCourseMaterial() {
		Course course = Course.builder()
				.courseTitle("Data structure and Algorithm")
				.credit(5).build();
		
		CourseMaterial cm = CourseMaterial.builder().url("www.google.com").course(course).build();
		courseMaterialRepository.save(cm);
		//System.out.println("Course MAterial Information : "+ cm);
	}
}
