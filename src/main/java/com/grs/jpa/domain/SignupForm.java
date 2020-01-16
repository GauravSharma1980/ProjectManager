package com.grs.jpa.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SignupForm 
{
	@NotBlank
	@Size(min=1,max=255 ,message = "{nameSizeError}")
	private String userName;
	
	@NotBlank
	private String password;
	
	@NotNull
	@Size(min = 1, max = 255)
	private String email;
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SignupForm [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}

	
	
}
