package com.example.onetoonemapping.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetoonemapping.entity.Laptop;
import com.example.onetoonemapping.entity.Student;
import com.example.onetoonemapping.repository.StudentRepository;
import com.example.onetoonemapping.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		student.getLaptop().setStudent(student);
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> students = studentRepository.findAll();
		List<Student> sts = new ArrayList<>();
		for (Student student : students) {
		    System.out.println("Student Name: " + student.getStudentName());
		    System.out.println("Laptop Model: " + student.getLaptop().getLaptopModel());
		    Laptop  lp= new Laptop();
		    lp.setLaptopId(student.getLaptop().getLaptopId());
		    lp.setLaptopModel(student.getLaptop().getLaptopModel());
		    lp.setStudent(student);
		    
		    Student st= new Student();
		    st.setStudentCourse(student.getStudentCourse());
		    st.setStudentId(student.getStudentId());
		    st.setStudentName(student.getStudentName());
		    st.setLaptop(lp);
		    
		    sts.add(st);
		    
		}
		return sts;
		
	}

	@Override
	public Student updateStudent(Student student) {
		
		Optional<Student> studentById = studentRepository.findById(student.getStudentId());
		
		if(studentById.isPresent()) {
			Student student2 = studentById.get();
			student2.setStudentCourse(student.getStudentCourse());
			student2.setStudentName(student.getStudentName());
			
			Laptop laptop = student2.getLaptop();
			laptop.setLaptopModel(student.getLaptop().getLaptopModel());
			studentRepository.save(student2);
		}
		return student;
		
	}

	@Override
	public void deleteById(Long id) {
		
		studentRepository.deleteById(id);
	}

}
