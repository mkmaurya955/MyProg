package com.example.onetoonemapping.service;

import java.util.List;

import com.example.onetoonemapping.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> getAllStudent();

	Student updateStudent(Student student);

	void deleteById(Long id);

}
