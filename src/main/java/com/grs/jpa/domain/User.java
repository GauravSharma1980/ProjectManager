package com.grs.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usr")
public class User {
	
	private static final int EMAIL_MAX = 250;
	private static final int NAME_MAX  = 50; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name = "email",nullable = false,length = EMAIL_MAX)
	private String email;
	
	@Column(name = "name",nullable = false,length = NAME_MAX)
	private String name;
	
	
	@Column(name = "password", nullable = false)
	private String password;
	
	
	
	
	

}
