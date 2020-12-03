package com.school.studentdemo.controller.rest.student;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.studentdemo.entity.course.CourseEntity;
import com.school.studentdemo.entity.student.StudentEntity;
import com.school.studentdemo.service.course.CourseService;
import com.school.studentdemo.service.student.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rest/student")
@AllArgsConstructor
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	private final Logger logger = LoggerFactory.getLogger(StudentRestController.class);

	@CrossOrigin
	@PostMapping("/create-student")
	public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentCreation) {
		try {
			logger.info("studentCreated.id=" + studentCreation.getStudentId());

			StudentEntity studentCreated = studentService.createNewStudent(studentCreation);
			return new ResponseEntity<>(studentCreated, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/get-student-by-student-id")
	public ResponseEntity<StudentEntity> getStudentById(@RequestParam Long id) {
		try {
			StudentEntity student = studentService.getStudentById(id);
			if (student == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(student, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/find-student-by-course-id")
	public ResponseEntity<List<StudentEntity>> findStudentByCourseId(@RequestParam Integer courseId) {
		try {
			List<StudentEntity> studentList = studentService.findStudentByCourseId(courseId);
			return new ResponseEntity<>(studentList, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/find-student-all")
	public ResponseEntity<List<StudentEntity>> findAllStudent(){
		try {
			List<StudentEntity> studentList = studentService.findAllStudent();
			return new ResponseEntity<>(studentList, HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@PutMapping("/update-student")
	public ResponseEntity<StudentEntity> updateStudentContact(@RequestBody StudentEntity studentEntity) {
		try {
			studentService.updateStudent(studentEntity);
			return new ResponseEntity<>(studentEntity, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@PutMapping("/update-student-contact")
	public ResponseEntity<StudentEntity> updateStudentContact(@RequestParam(required = true) Long id,
			@RequestParam(required = false) String studentName, @RequestParam(required = false) String email,
			@RequestParam(required = false) String phoneNumber) {
		try {
			StudentEntity updateStudentEntity = studentService.updateStudentContact(id, email, phoneNumber);
			if (updateStudentEntity == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(updateStudentEntity, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/find-all-course")
	public ResponseEntity<List<CourseEntity>> findAllCourse(){
		try {
			List<CourseEntity> courseList = courseService.findAllCourse();
			return new ResponseEntity<>(courseList, HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/delete-student-by-id")
	public ResponseEntity<Long> deleteStudentById(@RequestParam Long id) {
		try {
			StudentEntity student = studentService.getStudentById(id);
			if (student == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			} else {
				studentService.deleteStudentById(id);
				return new ResponseEntity<>(id, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
