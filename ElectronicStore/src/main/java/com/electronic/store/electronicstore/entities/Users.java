package com.electronic.store.electronicstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_INFO")
public class Users {

	@Id
	private String userId;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_email", unique = true)
	private String email;
	@Column(name = "user_password")
	private String password;
	@Column(name = "gender")
	private String gender;
	@Column(name = "about", length = 1000)
	private String about;
	@Column(name = "user_profile_name")
	private String userProfileName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getUserProfileName() {
		return userProfileName;
	}

	public void setUserProfileName(String userProfileName) {
		this.userProfileName = userProfileName;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", about=" + about + ", userProfileName=" + userProfileName + "]";
	}

	public Users(String userId, String name, String email, String password, String gender, String about,
			String userProfileName) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.about = about;
		this.userProfileName = userProfileName;
	}

	public Users() {
		super();
	}

}
