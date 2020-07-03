package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminLoginInfoBean implements Serializable{
	
	private String username;
	private String password;
	
	
	public AdminLoginInfoBean(String username, String password) {
		super();
		this.username=username;
		this.password=password;
		
	}

	 public AdminLoginInfoBean() {
		super();
	
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		 return "AdminLoginInfoBean [username" + username + ", password=" + password +"]";
}
	}
	

	


