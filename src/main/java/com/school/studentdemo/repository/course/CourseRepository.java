package com.school.studentdemo.repository.course;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.studentdemo.entity.course.CourseEntity;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<CourseEntity, Integer>{

}
