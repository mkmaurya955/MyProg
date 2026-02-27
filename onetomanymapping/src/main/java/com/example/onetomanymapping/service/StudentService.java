package com.example.onetomanymapping.service;

import java.util.List;

import com.example.onetomanymapping.entity.Student;

public interface StudentService {

	Student createStudent(Student student);

	Student updateStudent(Student student);

	List<Student> getAllStudents();

	Student getById(Long id);

	String deleteById(Long id);

}
