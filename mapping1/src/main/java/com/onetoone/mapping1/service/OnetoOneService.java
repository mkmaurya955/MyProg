package com.onetoone.mapping1.service;

import java.util.List;

import com.onetoone.mapping1.vo.Student;

public interface OnetoOneService {

	Student saveStudent(Student student);

	List<Student> get();

	Student updateStudent(Student student, long id);

}
