package com.jwt.springboot3andss6.model;

public class JwtResponse {

	private String jwtToken;
	private String username;

	// Getters and Setters
	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// Override toString() method
	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
	}

	// Constructors
	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}

	public JwtResponse() {
		super();
	}

	// Builder pattern implementation
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String jwtToken;
		private String username;

		public Builder jwtToken(String jwtToken) {
			this.jwtToken = jwtToken;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public JwtResponse build() {
			return new JwtResponse(jwtToken, username);
		}
	}

}
