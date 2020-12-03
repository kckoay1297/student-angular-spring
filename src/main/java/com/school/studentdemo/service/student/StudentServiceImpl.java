package com.school.studentdemo.service.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.studentdemo.entity.student.StudentEntity;
import com.school.studentdemo.repository.student.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	
	@Transactional
	@Override
	public StudentEntity createNewStudent(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);
	}
	
	@Transactional
	@Override
	public void updateStudent(StudentEntity newStudentEntity) {
		studentRepository.save(newStudentEntity);
	}
	
	@Transactional
	@Override
	public List<StudentEntity> findAllStudent() {
		return studentRepository.findAll();
	}
	
	@Transactional
	@Override
	public StudentEntity getStudentById(Long studentId) {
		Optional<StudentEntity> studentOptional = studentRepository.findById(studentId);
		if(studentOptional.isPresent()) {
			return studentOptional.get();
		}
		
		return null;
	}
	
	@Transactional
	@Override
	public StudentEntity updateStudentContact(Long studentId, String studentEmail, String studentPhoneNumber) {
		StudentEntity studentEntity = getStudentById(studentId);
		if(studentEntity != null) {
			if(StringUtils.isNotBlank(studentPhoneNumber)) {
				studentEntity.setPhoneNumber(studentPhoneNumber);
			}
			
			if(StringUtils.isNotBlank(studentEmail)) {
				studentEntity.setEmail(studentEmail);
			}
			
			return studentRepository.save(studentEntity);
		}else {
			return null;
		}
	}
	
	@Transactional
	@Override
	public List<StudentEntity> findStudentByCourseId(Integer courseId){
		List<StudentEntity> studentList = studentRepository.findStudentByCourseId(courseId);
		return studentList;
	}
	
	@Transactional
	@Override
	public void deleteStudentById(Long studentId) {
		studentRepository.deleteById(studentId);
	}
}
