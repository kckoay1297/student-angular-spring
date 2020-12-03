package com.school.studentdemo.entity.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.school.studentdemo.entity.student.StudentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COURSE")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class CourseEntity {

	@Id
	@Column(name = "COURSE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_generator")
	@SequenceGenerator(name = "course_id_generator", sequenceName = "course_id_seq")
	private Integer courseId;
	
	@Column(name = "COURSE_NAME")
	private String courseName;
	
	@Column(name = "DESCRIPTION")
	private String description;
		
	
}
