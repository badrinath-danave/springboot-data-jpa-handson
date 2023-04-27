package com.springboot.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String name);
	
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	//JPQL
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String email);
}