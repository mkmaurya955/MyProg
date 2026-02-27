package com.example.onetomanymapping.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.onetomanymapping.entity.Address;
import com.example.onetomanymapping.entity.Student;
import com.example.onetomanymapping.repository.StudentRepository;
import com.example.onetomanymapping.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		
		for(Address ad : student.getAdd()) {
			ad.setStudent(student);
		}
		return studentRepository.save(student);
	}
	 @Transactional
	@Override
	public Student updateStudent(Student student) {
		
		Optional<Student> findById = studentRepository.findById(student.getStudentId());
		if(findById.isPresent()) {
			Student student2 = findById.get();
			student2.setStudentName(student.getStudentName());
			student2.setStudentCourse(student.getStudentCourse());
			student2.setAdd(student.getAdd());
			studentRepository.save(student2);
		}
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
		
	}

	@Override
	public Student getById(Long id) {
		Optional<Student> findById = studentRepository.findById(id);
		return findById.get();
	}

	@Override
	public String deleteById(Long id) {
		studentRepository.deleteById(id);
		return "data deleted successfully..!";
	}

}
