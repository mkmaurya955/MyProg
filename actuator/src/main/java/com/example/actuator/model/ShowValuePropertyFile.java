package com.example.actuator.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp.username")
public class ShowValuePropertyFile {

	private String name;

	private String email;

	private String sal;

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

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "ShowValuePropertyFile [name=" + name + ", email=" + email + ", sal=" + sal + "]";
	}

	public ShowValuePropertyFile(String name, String email, String sal) {
		super();
		this.name = name;
		this.email = email;
		this.sal = sal;
	}

	public ShowValuePropertyFile() {
		super();
	}

}
