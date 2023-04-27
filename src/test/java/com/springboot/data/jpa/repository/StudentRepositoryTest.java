package com.springboot.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.data.jpa.entity.Guardian;
import com.springboot.data.jpa.entity.Student;
import com.springboot.data.jpa.entity.Student.StudentBuilder;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository ;
	
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
					.emailId("abc@gmail.com")
					.firstName("shabir")
					.lastName("dawoodi")
//					.guardianName("nikhil")
//					.guardianEmail("nikhil@gmail.com")
//					.guardianMobileNo("123456789")
					.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGaurdianDetails() {
		Guardian guardian = Guardian.builder()
					.name("nikhil")
					.email("xyz@hotmail.com")
					.mobileNo("827378463287")
					.build();
		
		Student student = Student.builder()
				.firstName("shivam")
				.lastName("kochu")
				.emailId("shivam@gmail.com")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		
		List<Student> studentList = studentRepository.findAll();
		
		System.out.println("studentList");
		studentList.forEach(s->System.out.println(s));
	}
	
	
	@Test
	public void printStudentFirstName() {
		List<Student> studentList = studentRepository.findByFirstName("shabir");
		System.out.println("studentList first name: "+ studentList);
	}
	
	@Test
	public void printStudentFirstNameWithAnyMatch() {
		List<Student> studentList = studentRepository.findByFirstNameContaining("sh");
		System.out.println(" ****studentList first name: "+ studentList);
	}
	
	@Test
	public void printStudentInfoWithFirstNameAndLastName() {
		List<Student> studentList = studentRepository.findByFirstNameAndLastName("shabir", "dawoodi");
		
		System.out.println(" ****Student Information "+ studentList);
	}

	@Test
	public void printStudentByEmailId() {
		Student student = studentRepository.getStudentByEmailAddress("abc@gmail.com");
		
		System.out.println("Email Information -> "+student);
		
	}
}
