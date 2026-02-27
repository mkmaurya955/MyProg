package com.jwt.springboot3andss6.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")

	private long id;

	private String userName;

	private String email;

	private String password;

	@OneToMany(targetEntity = UserRole.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userRole_fk", referencedColumnName = "id")
	private Set<UserRole> userRoles = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserInfo(long id, String userName, String email, String password, Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", userRoles=" + userRoles + "]";
	}

	public UserInfo() {
		super();
	}

}
