package com.example.onetoonemapping.entity;

import java.util.List;

public class CommonDto {

	private List<Student> student;

	private List<Laptop> laptop;

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	public CommonDto() {
		super();
	}

	@Override
	public String toString() {
		return "CommonDto [student=" + student + ", laptop=" + laptop + "]";
	}

	public CommonDto(List<Student> student, List<Laptop> laptop) {
		super();
		this.student = student;
		this.laptop = laptop;
	}

}
