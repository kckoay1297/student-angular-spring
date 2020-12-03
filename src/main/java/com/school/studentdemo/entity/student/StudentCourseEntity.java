package com.school.studentdemo.entity.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STUDENT_COURSE")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
public class StudentCourseEntity {

	@Id
	@Column(name = "STUDENT_COURSE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_course_id_generator")
	@SequenceGenerator(name = "student_course_id_generator", sequenceName = "student_course_id_seq")
	private Integer studentCourseId;
	
	@Column(name = "COURSE_ID")
	private Integer courseId;
	
	@Column(name = "STUDENT_ID")
	private Integer studentId;
	
}
