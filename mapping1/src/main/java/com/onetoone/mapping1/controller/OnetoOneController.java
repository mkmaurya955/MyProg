package com.onetoone.mapping1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.mapping1.service.OnetoOneService;
import com.onetoone.mapping1.vo.Student;

@RestController
public class OnetoOneController {
	
	@Autowired
	private OnetoOneService onetoOneService;
	
	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {
		return onetoOneService.saveStudent(student);
		
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student,long id) {
		return onetoOneService.updateStudent(student, id);
		
	}
	
	@GetMapping("/getAllData")
	public List<Student> getAll(){
		return onetoOneService.get();
	}

}
