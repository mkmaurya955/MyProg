package com.manytomany.relation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manytomany.relation.service.StudentService;
import com.manytomany.relation.vo.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
	
	@GetMapping("getAll")
	public List<Student> getAllStudentCourse() {
		return studentService.getAll();
	}
	
	@GetMapping("getData/{studentId}")
	public Optional<Student> getStudentWithId(@PathVariable Long studentId) {
		return studentService.findStudentById(studentId);
	}
}
