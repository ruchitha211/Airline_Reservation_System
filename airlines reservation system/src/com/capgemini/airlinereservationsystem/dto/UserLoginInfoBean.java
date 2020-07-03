package com.capgemini.airlinereservationsystem.dto;

public class UserLoginInfoBean {
	
	private int regid;
	
	private String username;
	private String password;
	
	
	public UserLoginInfoBean() {
		
	}
	
	
	public UserLoginInfoBean(int regid, String username, String password) {
		this.regid=regid;
		this.username=username;
		this.password=password;
		
	}

	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
		this.regid = regid;
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

	

}
