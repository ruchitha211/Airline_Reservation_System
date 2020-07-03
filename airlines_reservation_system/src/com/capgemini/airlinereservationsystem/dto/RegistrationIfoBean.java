package com.capgemini.airlinereservationsystem.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RegistrationIfoBean implements Serializable {
	
	private int regid;
	private String name;
	private String email;
	private String username;
	private String password;
	private String confirmpass;
	
	
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
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
	public String getConfirmpass() {
		return confirmpass;
	}
	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}
	
	

}
