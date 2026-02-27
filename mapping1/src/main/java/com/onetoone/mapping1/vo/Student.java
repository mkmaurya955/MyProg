package com.onetoone.mapping1.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT1")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String stuName;

	private String studEmail;

	@OneToOne(targetEntity = Pan.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "pan_id", referencedColumnName = "id")
	private Pan pan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStudEmail() {
		return studEmail;
	}

	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", studEmail=" + studEmail + ", pan=" + pan + "]";
	}

	

}
