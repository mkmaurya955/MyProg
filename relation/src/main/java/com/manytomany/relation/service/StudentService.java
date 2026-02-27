package com.manytomany.relation.service;

import java.util.List;
import java.util.Optional;

import com.manytomany.relation.vo.Student;

public interface StudentService {

	Student insertStudent(Student student);

	List<Student> getAll();

	Optional<Student> findStudentById(Long studentId);

}
