package com.school.studentdemo.repository.student;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.studentdemo.entity.student.StudentEntity;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

	@Query("select s from StudentEntity s where s.studentId in (select c.studentId from StudentCourseEntity c where c.courseId = ?1)")
	List<StudentEntity> findStudentByCourseId(Integer courseId);
}
