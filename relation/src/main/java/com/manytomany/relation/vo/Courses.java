package com.manytomany.relation.vo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "COURSES")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String courseType;

	private String title;

	private String feeCouses;

	private String courseDesp;
	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	@JsonBackReference 
	private Set<Student> student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFeeCouses() {
		return feeCouses;
	}

	public void setFeeCouses(String feeCouses) {
		this.feeCouses = feeCouses;
	}

	public String getCourseDesp() {
		return courseDesp;
	}

	public void setCourseDesp(String courseDesp) {
		this.courseDesp = courseDesp;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", courseType=" + courseType + ", title=" + title + ", feeCouses=" + feeCouses
				+ ", courseDesp=" + courseDesp + ", student=" + student + "]";
	}

	public Courses(Long id, String courseType, String title, String feeCouses, String courseDesp,
			Set<Student> student) {
		super();
		this.id = id;
		this.courseType = courseType;
		this.title = title;
		this.feeCouses = feeCouses;
		this.courseDesp = courseDesp;
		this.student = student;
	}

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

}
