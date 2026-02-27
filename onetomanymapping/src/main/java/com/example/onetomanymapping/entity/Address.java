package com.example.onetomanymapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ONETOMANY_JPAADDRESS")
public class Address {
	@Id
	@Column(name = "ID") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addId;
	@Column(name = "CITY")
	private String city;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "PINCODE")
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonBackReference
	private Student student;

	public Long getAddId() {
		return addId;
	}

	public void setAddId(Long addId) {
		this.addId = addId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", city=" + city + ", country=" + country + ", pincode=" + pincode
				+ ", student=" + student + "]";
	}

	public Address(Long addId, String city, String country, String pincode, Student student) {
		super();
		this.addId = addId;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		this.student = student;
	}

	public Address() {
		super();
	}

}
