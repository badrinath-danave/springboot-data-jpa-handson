package com.springboot.data.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

	@Id
	@SequenceGenerator( name="course_sequence",
	sequenceName = "course_sequence",
	allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="course_sequence")
	private Long courseId;
	private String courseTitle;
	private Integer credit;
	
	
	@OneToOne(mappedBy = "course")
	private CourseMaterial cm;
	
}
