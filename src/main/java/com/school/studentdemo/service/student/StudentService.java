package com.school.studentdemo.service.student;

import java.util.List;

import com.school.studentdemo.entity.student.StudentEntity;

public interface StudentService {

	StudentEntity createNewStudent(StudentEntity studentEntity);

	void updateStudent(StudentEntity newStudentEntity);

	List<StudentEntity> findAllStudent();

	StudentEntity getStudentById(Long studentId);

	StudentEntity updateStudentContact(Long studentId, String studentEmail, String studentPhoneNumber);

	List<StudentEntity> findStudentByCourseId(Integer courseId);

	void deleteStudentById(Long studentId);

}
