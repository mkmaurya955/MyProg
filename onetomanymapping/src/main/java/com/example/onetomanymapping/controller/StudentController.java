package com.example.onetomanymapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomanymapping.entity.Student;
import com.example.onetomanymapping.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public String createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
		return "data added successfully..!";
	}

	@PostMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@GetMapping("/getAll")
	public List<Student> getAllStudent() {
		return studentService.getAllStudents();
	}

	@GetMapping("/getById")
	public Student getById(@RequestParam("id") Long id) {
		return studentService.getById(id);
	}

	@GetMapping("/deleteById")
	public String deleteById(@RequestParam("id") Long id) {
		return studentService.deleteById(id);
	}

}
