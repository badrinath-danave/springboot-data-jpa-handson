package com.springboot.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.data.jpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
