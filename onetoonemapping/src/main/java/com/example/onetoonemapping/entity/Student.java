package com.example.onetoonemapping.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JPA_STUDENT")
public class Student {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@Column(name = "STUDENT_COURSE")
	private String studentCourse;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Laptop laptop;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCourse=" + studentCourse
				+ ", laptop=" + laptop + "]";
	}

	public Student(Long studentId, String studentName, String studentCourse, Laptop laptop) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.laptop = laptop;
	}

	public Student() {
		super();
	}

}
