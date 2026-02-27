package com.manytomany.relation.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.relation.repository.CouresRepository;
import com.manytomany.relation.repository.StudentRepository;
import com.manytomany.relation.service.StudentService;
import com.manytomany.relation.vo.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CouresRepository courseRepository;
	
	
	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}


	@Override
	public Optional<Student> findStudentById(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId);
	}

}
