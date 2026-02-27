package com.onetoone.mapping1.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.onetoone.mapping1.repository.PanRepository;
import com.onetoone.mapping1.repository.StudentRepository;
import com.onetoone.mapping1.service.OnetoOneService;
import com.onetoone.mapping1.vo.Student;

@Service
public class OnetoOneServiceImpl implements OnetoOneService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private PanRepository panRepository;
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> get() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(@RequestBody Student student,@RequestParam long id) {
		Optional<Student> updateData = studentRepository.findById(id);
		if (updateData.isPresent()) {
			Student custr = updateData.get();
			custr.setStuName(student.getStuName());
			custr.setStudEmail(student.getStudEmail());
			// set this pan for update the details
			custr.setPan(student.getPan());
			custr.setId(student.getId());
			
			return studentRepository.save(custr);
		}
		return null;
	}

}
