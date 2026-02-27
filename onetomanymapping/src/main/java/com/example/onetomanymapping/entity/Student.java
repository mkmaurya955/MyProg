package com.example.onetomanymapping.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ONETOMANY_STUDENTJPA")
public class Student {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	@Column(name = "STUDENTNAME") 
	private String studentName;
	@Column(name = "STUDENTCOURSE")
	private String studentCourse;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Address> add = new ArrayList<>();

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

	public List<Address> getAdd() {
		return add;
	}

	public void setAdd(List<Address> add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCourse=" + studentCourse
				+ ", add=" + add + "]";
	}

	public Student(Long studentId, String studentName, String studentCourse, List<Address> add) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.add = add;
	}

	public Student() {
		super();
	}

}
