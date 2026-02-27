package com.example.onetoonemapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "JPA_LAPTOP")
public class Laptop {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long laptopId;
	@Column(name = "LAPTOP_MODEL")
	private String laptopModel;

	@OneToOne(targetEntity = Student.class)
	@JoinColumn(name = "student_id")
	@JsonBackReference
	private Student student;

	public Long getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(Long laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopModel() {
		return laptopModel;
	}

	public void setLaptopModel(String laptopModel) {
		this.laptopModel = laptopModel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopModel=" + laptopModel + ", student=" + student + "]";
	}

	public Laptop(Long laptopId, String laptopModel, Student student) {
		super();
		this.laptopId = laptopId;
		this.laptopModel = laptopModel;
		this.student = student;
	}

	public Laptop() {
		super();
	}

}
