package com.school.studentdemo.service.course;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.studentdemo.entity.course.CourseEntity;
import com.school.studentdemo.repository.course.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Transactional
	@Override
	public List<CourseEntity> findAllCourse(){
		return courseRepository.findAll();
	}
}
