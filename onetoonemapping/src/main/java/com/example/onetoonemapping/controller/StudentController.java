package com.example.onetoonemapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetoonemapping.entity.Student;
import com.example.onetoonemapping.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/createStudent")
	public String createStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "Saved SuccessFully";
		
	}
	@GetMapping("/getAll")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
				
	}
	@PostMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@DeleteMapping("/deleteById")
	public String deleteById(@RequestParam("id") Long id) {
		studentService.deleteById(id);
		return "deleted Successfully...!";
		
	}

}
