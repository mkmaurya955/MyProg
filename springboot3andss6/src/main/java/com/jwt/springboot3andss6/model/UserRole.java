package com.jwt.springboot3andss6.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROLES")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", name=" + name + "]";
	}

	public UserRole(long id, String name, UserInfo userInfo) {
		super();
		this.id = id;
		this.name = name;
	}

	public UserRole() {
		super();
	}

}
