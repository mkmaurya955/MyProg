package com.manytomany.relation.vo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String studName;

	private int age;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE_TABLE", joinColumns = {
			@JoinColumn(name = "student_id", referencedColumnName = "id") },
				inverseJoinColumns = {
					@JoinColumn(name = "course_id", referencedColumnName = "id") })
	
	@JsonManagedReference // getting findall
	private Set<Courses> courses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Student(Long id, String studName, int age, Set<Courses> courses) {
		super();
		this.id = id;
		this.studName = studName;
		this.age = age;
		this.courses = courses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studName=" + studName + ", age=" + age + ", courses=" + courses + "]";
	}
	
	

}
