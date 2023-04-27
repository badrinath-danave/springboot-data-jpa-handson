package com.springboot.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String name);
	
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	//JPQL
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String email);
	
	//@Query(value="select * from student_tbl s where s.email_address= ?1", nativeQuery = true)
	@Query(value="select * from student_tbl s where s.email_address= :emailId", nativeQuery = true)
	Student getStudentByEmailAddressNativeQuery(@Param("emailId") String email);
	
	@Modifying
	@Transactional
	@Query(value="update student_tbl setfirst_name= ?1 where email_address=?2",
			nativeQuery=true)
	int updateStudentNameByEmailId(String firstName, String email);
}
