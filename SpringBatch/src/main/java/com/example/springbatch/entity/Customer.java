package com.example.springbatch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = " TITLE")
	private String title;
	@Column(name = "NAME")
	private String name;
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	@Column(name = "WEBSITE")
	private String webSite;
	@Column(name = "USER_NAME")
	private String userName;

}
